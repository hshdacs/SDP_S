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

        ```mermaid
        flowchart TD
            Start --> id1
            id1{x != y} -- no --> Stop
            id1 -- yes --> id2{x > y}
            id2 -- yes --> A[x = x - y]
            id2 -- no --> B[y = y - x]
            A --> id1
            B --> id1
        ```

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
    - Exercise 1
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

    - Exercise 2

        Write a guessing game, where the computer randomly choose
        a secret number and the user can guess this number
        a) let the user know if the number is lower or higher
        b) MasterMind:
            - give a star (*) when a digit is correct and in its correct position
            - give a circle (o) when a digit is present, but on a wrong position
            e.g. secret number is 4713, guess uis 2739: *o--

### Session 4
06.11.2024

- Recall last session
    - Datatypes
        - Primitives (boolean, byte, short, char, int, long, float, double)
        - Complex (all others)
            - Array (aka Field, Vector)
            - Object
    - Flow Control
        - Loops (while, for, break, continue)
        - Decisions (if, else)
    - Methods
        - Structure: Head Body
            - Head: Signature and some other stuff
                e.g. public static void main(String[] args)
                     ------------------ +++++++++++++
                Signature: Name of method + Datatypes of Parameters
            - Body enclosed in curly brackets (can be omitted)
        - Call paradigms
            - Call by Value (all primitive datatypes)
            - Call by Reference (all others)
    
- Object Oriented Programming
    - Class (is a new compound datatype)
        is a template/blueprint for objects
        - what kind of information is required: attribute (member, field, property)
        - behaviour: method (operation, messages)
    - Object (created based on a class)
        - it contains the values for the attributes
        - but behaviour is still defined in the class
    - Main concept of OOP:
        Model the real world to be present in software,
        and binding data and operation together
        - Encapsulation (aka information hiding): Private, Public
            -> **Every attribute must be private, and only necessary methods could be public**
        - Inheritance
            - code can be reused
            - hiearchy
            => but an **is-a** connection must be given
        - Polymorphy
    - Practical issues
        - Constructor (ctor)
            - standard constructor receive values for all attributes
            - default constructor (w/o parameter) is automaticall given if no ctor is provided, which will call the super ctor w/o parameters, but will vanish if at lease one ctor is given
            - every other (overloaded) ctor will use the standard ctor (DRY - Don't repeat yourself)
        - Self reference
            - this : Reference to the own object in current context (class)
            - super: Reference to the own object in parental context (base class)
        - Access control
            by providing Getter/Setter methods

    E.g.
        Writing a class (Ratio) for calculating with ratio numbers (fraction)
        with two attributes: enumarator, denominator,
        and some methods: add, sub, mult, div, reciprocal, reduce,
        and two constructor with one and two parameters

    Exercise 3 : Kingdom
        In a kingdom there are residents who must pay taxes, at 1/10 of its income,
        but at least 1 coin.
        But there a other residents with benefits, who pay other taxes, e.g.
            - king : pays only 1 coin, as his/her income is 0
            - noble : pays at least 20 coins
            - pawn : pays as a normal resident
            - adscript: pays normal as resident, but his/her income is deducted by 12 coins
        There is a resident hierachy
            resident : king, noble, pawn
            pawn : adscript
        The resident is a class with two attributes (name, income), and has a method called "taxes()", which shows how much this resident has to pay tax!
