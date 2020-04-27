# Is it the Flag? (JAVA)

Pedro was disappointed because he didn't speak Python well enough to capture some of the flags on CTFLearn. His plan for revenge was to create one in his native language (Java). The flag is a String of 6 alphanumeric characters. Capture it. `https://mega.nz/#!SHp1xCAL!I9-Zy4kwu_JY019MiYZ6CzGey8sJ6UvqE-ML2idmkrs`

```java
public class IsItTheFlag {

    public static boolean isFlag(String str) {
        return str.hashCode() == 1471587914 && str.toLowerCase().hashCode() == 1472541258;
    }

    public static void main(String[] args) {

        String flag = "------";

        if (isFlag(flag))
            System.out.println("You found it!");
        else
            System.out.println("Try again :(");

    }
}
```

In Java, the hashcode of string `abc` is calculated as `a * pow(3 - 1) + b * pow(3 - 2) + c * pow(3 - 3)` where `a`, `b`, and `c` each represents a character.

Hence, we can use the following script to backtrack the original string using the hashcodes.

```python
#!/usr/bin/env python3

def getSolution(hashcode_rem, chars_rem):
    possible_solutions = []
    rem = hashcode_rem % 31

    while rem < 123 and hashcode_rem - rem >= 0:
        if chr(rem).isdigit() or chr(rem).isalpha():
            if chars_rem == 1:
                solution = [rem]
                possible_solutions.append(solution)
            else:
                sub_solutions = getSolution((hashcode_rem - rem) // 31, chars_rem - 1)
                for sub_solution in sub_solutions:
                    solution = sub_solution + [rem]
                    possible_solutions.append(solution)
        rem += 31
    return possible_solutions

def checkSolution(solution, target_hashcode):
    tot = 0
    for i in range(len(solution)):
        p = len(solution) - 1 - i
        tot += solution[i] * pow(31, p)
    return tot == target_hashcode

if __name__ == '__main__':
    hashcode = 1471587914
    lowercase_hashcode = 1472541258

    solutions = getSolution(hashcode, 6)
    target_solutions = []

    for solution in solutions:
        lowercase_solution = [ord(chr(c).lower()) for c in solution]
        if checkSolution(lowercase_solution, lowercase_hashcode):
            target_solutions.append(solution)

    print(target_solutions)

    target_solution = target_solutions[0]
    flag = "".join([chr(c) for c in target_solution])
    print(f"flag = {flag}")
```

```bash
$ python3 exploit.py
[[48, 103, 72, 122, 120, 89]]
flag = 0gHzxY
```
