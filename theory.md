# Software Development Practice

## Theoretical stuff

### Session 1
15.10.2024

- Introduction
- CORE
- Why SDP

### Session 2
24.10.2024

- Round of introductions
    - Name
    - Expertise
    - Weakspots
    - Hobbies
    - Why did you choose SRH?
- IDE
    - Integrated Development Environment
        - Why? - We need tools for programming (Compiler)
        - What can it do?
            - Compiler
            - Smart editor
            - Debugger
    - Download
        - Eclipse for Java
        - IntelliJ
        - Visual Studio Code
            (https://code.visualstudio.com/Download)
        - Java Development Kit
            (https://www.oracle.com/java/technologies/downloads/)
        - Version Control System (Git)
            (https://git-scm.com/)
    - Installation
    - Configuration

#### Fundamentals (of Programming)

- Bit (Binary Digit)
- Byte, Word, Doubleword, Quadword
- Kilo, Mega, Giga, Tera, Peta, Exa (1 KB of Data => 1 KiBi Data)
- ASCII (ANSI), ISO, UTF
- CPU, MMU, ALU, DMA, PCI, SATA, USB, BIOS, UEFI, OS, FAT, NTFS
- Number System
- Data types
    - 1 Bit : Bool(ean)
    - 8 Bit : byte (char) : -128 .. +127
    - 16 Bit : short 
    - 32 Bit : int (Integer)
    - 64 Bit : long
    => these data types can only store non fractional numbers
    - 32 Bit : float (be aware: float are **evil**)
    - 64 Bit : double
    - 8/16/32 Bit : char
        (a single character of a text)
- Operation
    =,
    +, -, /, *, %,
    ++, --,
    +=, -=, /=, *=, %=,
    &, |, ^, !, &&, ||,
    ==, !=, <=, >=
- Algorithm
    - Sequence
    - Condition (if, switch)
    - Loop (while, for, do-while)

### Session 3
31.10.2024

- Teams
- GitHub
    - Setup **private** repository
    - Add team mate and **hshdacs** as collaborator
- Coding

#### Fundamentals (of Programming) - Continuation

- Algorithm
    - Euclid (Elements)
    When (c,d) is not (a,b), and taken alternating (a,b) or (c,d) the
    smallest from the tallest, then it will eventually remain a number
    that measures both of the previous.
    aka GCD (greates common divider)
    e.g. (a,b) = 24, (c,d) = 16
    1) 24 != 16
    2) 24 > 16
    3) (a,b) set to 24 - 16 = 8
    4) 8 != 16
    5) 8 < 16
    6) (c,d) set to 16 - 8 = 8
    7) 8 == 8
    - Formalism of Algorithms
        - Pseudo Code
            (in theory there is no rule for pseudo code, but use same words for the single steps of the algorithm)
            (a, b) => x, (c, d) => y
            while x != y
                if x > y : x = x - y
                otherwise: y = y - x
        - Flowchart
        - Nassi-Schneiderman Diagram (Struktogramm)
    - Characteristics of Algorithms
        - Determinism
        - Determination
        - Termination
        - Effectiveness
        - Complexity (Time & Space)
            - Landau Notation
                - O(1) - constant calculation
                - O(log2 n) - logarithmic calculation
                - O(n) - linear
                - O(n * log2 n) - linearithmic
                - O(n²) - square
                - O(n**k) - polynomial
                - O(k**n) - exponential
            - Special group of algorithms
                NP (complete) - non-deterministic, polynomial
    - Exercise
        Collatz - Number/Sequence
        there is some integer n

        while (n != 1)
            if (n is even): n = n/2
            otherwise: n = 3*n + 1

        The big question is, will this algorith terminate for
        every number of n?

        For the experts:
            Find the biggest length of Collatz Sequence between
            1 and 1'000'000
