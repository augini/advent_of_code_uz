# source => https://github.com/fstermann/advent-of-code-22/blob/main/day05/pretty.py

from __future__ import annotations

import curses
import os
import re
import time
from typing import Generator

INPUT_TXT = os.path.join(os.path.dirname(__file__), "input.txt")


def read_input() -> str:
    with open(INPUT_TXT) as f:
        return f.read()


Crates = list[list[str]]


class CraneView:
    stdsrc: curses._CursesWindow
    max_y: int
    max_x: int

    hook_x: int
    hook_y: int

    CRANE_HOOK: str = "A"
    CRANE_HUT: str = "[##]=\\==-_"
    CRANE_TOWER: str = "||"
    CRANE_BASE: str = r"_/=[||]=\_"

    crane_top: int = 10
    MAX_CRATES: int = 10
    LINE_BUFFER: int = 6

    n_crates: int = 9
    slack: int = 0
    cargo: str = " "

    FPS: int = 60  # not accurate

    def __init__(self, stdsrc: curses._CursesWindow):
        self.stdsrc = stdsrc
        self.max_y, self.max_x = stdsrc.getmaxyx()
        self.max_y -= 1
        self.max_x -= 1

        self.hook_x = 1
        self.hook_y = self.hook_rest_y

        self.CRATE_SPACE = len(self.make_crate("X")) + 1  # +1 for space
        self.MIN_Y_CRATE = self.max_y - 2  # -2 for active crates and index row

        self.slack = 0

        self._debug = ""  # You may use this for debugging

        # Init curses screen
        stdsrc.clear()
        stdsrc.refresh()
        stdsrc.nodelay(True)

        curses.curs_set(0)

        curses.start_color()
        curses.use_default_colors()

        curses.init_pair(1, curses.COLOR_YELLOW, -1)
        self.CRANE_COLOR = curses.color_pair(1)
        curses.init_pair(2, curses.COLOR_GREEN, -1)
        self.TOP_CRATE = curses.color_pair(2)
        curses.init_pair(3, curses.COLOR_CYAN, -1)
        self.ACTIVE_CRATE = curses.color_pair(3) | curses.A_BOLD
        curses.init_pair(4, curses.COLOR_RED, -1)
        self.INACTIVE_CRATE = curses.color_pair(4) | curses.A_BOLD

    def render(self, crates) -> None:
        self.n_crates = len(crates)

        self.stdsrc.clear()

        self.stdsrc.addstr(0, 0, self._debug)
        self.render_crane()
        self.render_current_crates(crates)
        self.render_index_row(crates)
        self.render_crates(crates)

        self.stdsrc.refresh()
        self.stdsrc.getch()
        time.sleep(1 / self.FPS)

    @property
    def crane_hut_x(self) -> int:
        return self.crane_x + len(self.CRANE_BASE) - len(self.CRANE_HUT)

    @property
    def crane_height(self) -> int:
        return self.max_y - self.crane_top

    @property
    def jib_y(self) -> int:
        return self.crane_top - 1

    @property
    def hook_rest_y(self) -> int:
        return self.crane_top + 2 + self.slack

    @property
    def crane_x(self) -> int:
        crane_x = self.CRATE_SPACE * (self.n_crates + 1)
        if crane_x + len(self.CRANE_BASE) > self.max_x:
            raise ValueError("Too many crates for screen width")
        return crane_x

    @property
    def tower_x(self) -> int:
        return (
            self.crane_x + (len(self.CRANE_BASE) - len(self.CRANE_TOWER)) // 2
        )  # noqa: E501

    def render_crane(self) -> None:
        self.render_crane_base()
        self.render_crane_jib()
        self.render_crane_hook()

    def render_crane_base(self) -> None:
        # Base
        self.stdsrc.addstr(
            self.max_y,
            self.crane_x,
            self.CRANE_BASE,
            self.CRANE_COLOR,
        )

        # Tower
        for y in range(self.crane_top, self.max_y):
            self.stdsrc.addstr(
                y,
                self.tower_x,
                self.CRANE_TOWER,
                self.CRANE_COLOR,
            )

        # Weight
        self.stdsrc.addstr(
            self.crane_top - 1,
            self.crane_hut_x,
            self.CRANE_HUT,
            self.CRANE_COLOR,
        )

    def render_crane_jib(self) -> None:
        jib = "=" * (self.crane_hut_x - self.hook_x)
        self.stdsrc.addstr(self.jib_y, self.hook_x, jib, self.CRANE_COLOR)

    def render_crane_hook(self) -> None:
        self.stdsrc.addstr(self.jib_y, self.hook_x, "/", self.CRANE_COLOR)
        for y in range(self.jib_y + 1, self.hook_y - 1):
            self.stdsrc.addstr(y, self.hook_x, "|")

        self.stdsrc.addstr(
            self.hook_y - 1,
            self.hook_x,
            self.CRANE_HOOK,
            self.CRANE_COLOR,
        )
        crate = self.make_crate(self.cargo)
        self.stdsrc.addstr(
            self.hook_y,
            self.hook_x - 1,
            crate[0],
            self.CRANE_COLOR,
        )
        self.stdsrc.addstr(
            self.hook_y,
            self.hook_x,
            crate[1],
            self.TOP_CRATE,
        )
        self.stdsrc.addstr(
            self.hook_y,
            self.hook_x + 1,
            crate[2],
            self.CRANE_COLOR,
        )

    def render_current_crates(self, crates: Crates) -> None:
        for x, items in enumerate(crates):
            col = self.ACTIVE_CRATE if items else self.INACTIVE_CRATE
            self.stdsrc.addstr(
                self.max_y,
                x * self.CRATE_SPACE,
                self.make_crate(items[-1]) if items else "[/]",
                col,
            )

    def render_index_row(self, crates: Crates) -> None:
        index_row = "".join(f" {x + 1}  " for x in range(len(crates)))
        self.stdsrc.addstr(self.max_y - 1, 0, index_row, curses.A_BOLD)

    def render_crates(self, crates: Crates) -> None:
        for x, c in enumerate(crates):
            for y, item in enumerate(c):
                col = self.TOP_CRATE if y == len(c) - 1 else 1
                self.stdsrc.addstr(
                    self.MIN_Y_CRATE - y,
                    x * self.CRATE_SPACE,
                    self.make_crate(item),
                    col,
                )

    def render_move(self, crates: Crates, from_: int, to: int) -> None:
        # Always match crane height to max crates
        self.crane_top = self.max_y - self.max_crates(crates)
        self.crane_top -= self.LINE_BUFFER

        self.set_slack(crates, self.crate_x_to_number(self.hook_x), from_)

        from_x, from_y = self.get_crate_pos(crates, from_)
        to_x, to_y = self.get_crate_pos(crates, to)

        # Move hook to target crate
        for _ in self.move_jib_to_x(from_x):
            self.render(crates)

        self.set_slack(crates, from_, to)

        for _ in self.move_jib_to_y(from_y):
            self.render(crates)

        self.cargo = crates[from_ - 1].pop()

        # Move crate to destination
        for _ in self.move_jib_to_y(self.hook_rest_y):
            self.render(crates)

        for _ in self.move_jib_to_x(to_x):
            self.render(crates)

        for _ in self.move_jib_to_y(to_y - 1):
            self.render(crates)

        crates[to - 1].append(self.cargo)
        self.cargo = " "

        # Reset hook
        for _ in self.move_jib_to_y(self.hook_rest_y):
            self.render(crates)

    @staticmethod
    def max_crates(crates: Crates) -> int:
        return max(len(items) for items in crates)

    @staticmethod
    def full_range(start: int, end: int) -> range:
        if start > end:
            return range(start, end - 1, -1)
        return range(start, end + 1)

    @staticmethod
    def get_min_height(crates: Crates, from_: int, to: int) -> int:
        a, b = min(from_, to), max(from_, to)
        return max(len(c) for c in crates[a - 1 : b])

    @staticmethod
    def make_crate(crate: str) -> str:
        return f"[{crate}]"

    def move_jib_to_x(self, to_x: int) -> Generator[int, None, None]:
        for x in self.full_range(self.hook_x, to_x):
            self.hook_x = x
            yield x

    def move_jib_to_y(self, to_y: int) -> Generator[int, None, None]:
        for y in self.full_range(self.hook_y, to_y):
            self.hook_y = y
            yield y

    def set_slack(self, crates: Crates, from_: int, to: int) -> None:
        min_height = self.get_min_height(crates, from_, to)
        top = self.crane_height
        new_slack = top - min_height - self.LINE_BUFFER + 1

        for y in self.full_range(self.slack, new_slack):
            self.slack = y
            self.hook_y = self.hook_rest_y
            self.render(crates)

    def crate_x_to_number(self, x: int) -> int:
        return (x - 1) // self.CRATE_SPACE + 1

    def get_crate_pos(self, crates: Crates, crate: int) -> tuple[int, int]:
        x = 1 + (crate - 1) * self.CRATE_SPACE
        y = self.MIN_Y_CRATE - len(crates[crate - 1])
        return x, y


def puzzle1_pretty(stdsrc: curses._CursesWindow, input_: str):
    crane_view = CraneView(stdsrc)

    crate_config, moves = input_.split("\n\n")
    crate_stacks = crate_config.splitlines()[::-1]

    pos = [i for i, c in enumerate(crate_stacks[0]) if c != " "]
    crates: Crates = [[] for _ in pos]

    for line in crate_stacks[1:]:
        for i, p in enumerate(pos):
            crates[i] += [line[p]] if p < len(line) and line[p] != " " else []

    for move in moves.splitlines():
        n, from_, to_ = (int(m) for m in re.findall(r"[0-9]+", move))

        for _ in range(n):
            crane_view.render_move(crates, from_, to_)


INPUT = """\
    [D]
[N] [C]
[Z] [M] [P]
 1   2   3
move 1 from 2 to 1
move 3 from 1 to 3
move 2 from 2 to 1
move 1 from 1 to 2
"""

if __name__ == "__main__":
    curses.wrapper(puzzle1_pretty, read_input())
