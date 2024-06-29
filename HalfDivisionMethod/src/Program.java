import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("f(x) = ax⁴ + bx³ + cx² + dx + e");
        System.out.println("Введите коэффиценты: ");
        System.out.print("a = ");
        int a = input.nextInt();
        System.out.print("b = ");
        int b = input.nextInt();
        System.out.print("c = ");
        int c = input.nextInt();
        System.out.print("d = ");
        int d = input.nextInt();
        System.out.print("e = ");
        int e = input.nextInt();

        if(a == 0 & b == 0 & c == 0 & d == 0){
            System.out.printf("f(x) = %d", e);
            return;
        }

        System.out.println();
        printEquation(a, b, c, d, e);
        calculateByHalfDivision(a, b, c, d);
    }

    public static void printEquation(int a, int b, int c, int d, int e){
        StringBuilder equation = new StringBuilder("f(x) = ");
        if(a > 0)
            equation.append(a + "x⁴ ");
        else if(a < 0)
            equation.append("- " + Math.abs(a) + "x⁴ ");

        if(b > 0 & a != 0)
            equation.append("+ " + b + "x³ ");
        else if(b < 0)
            equation.append("- " + Math.abs(b) + "x³ ");
        else if(b > 0 & a == 0)
            equation.append(b + "x³ ");

        if( (c > 0 & b != 0) || (b == 0 & a != 0) )
            equation.append("+ " + c + "x² ");
        else if(c < 0)
            equation.append("- " + Math.abs(c) + "x² ");
        else if(c > 0 & b == 0 & a == 0)
            equation.append(Math.abs(c) + "x² ");

        if( (d > 0 & c != 0) || (c == 0 & (b != 0 || a != 0)) )
            equation.append("+ " + d + "x ");
        else if(d < 0)
            equation.append("- " + Math.abs(d) + "x ");
        else if(d > 0 && c == 0)
            equation.append(d + "x ");

        if( (e > 0 & d != 0) || (d == 0 & (c != 0 || b != 0 || a != 0)) )
            equation.append("+ " + e);
        else if(e < 0)
            equation.append("- " + Math.abs(e));
        else if(e > 0 & d == 0)
            equation.append(e);

        System.out.println(equation);
    }

    public static void printEquation(int a, int b, int c, int d){
        StringBuilder equation = new StringBuilder("f'(x) = ");
        if(a > 0)
            equation.append(a + "x³ ");
        else if(a < 0)
            equation.append("- " + Math.abs(a) + "x³ ");

        if(b > 0 & a != 0)
            equation.append("+ " + b + "x² ");
        else if(b < 0)
            equation.append("- " + Math.abs(b) + "x² ");
        else if(b > 0 & a == 0)
            equation.append(b + "x² ");

        if( (c > 0 & b != 0) || (c > 0 & (b == 0 & a != 0) ) )
            equation.append("+ " + c + "x ");
        else if(c < 0)
            equation.append("- " + Math.abs(c) + "x ");
        else if(c > 0 & b == 0 & a == 0)
            equation.append(Math.abs(c) + "x ");

        if( (d > 0 & c != 0) || (d > 0 & (c == 0 & (b != 0 || a != 0) ) ) )
            equation.append("+ " + d);
        else if(d < 0)
            equation.append("- " + Math.abs(d));
        else if(d > 0 & c == 0)
            equation.append(d);

        System.out.println(equation);
    }

    public static void calculateByHalfDivision(int a, int b, int c, int d){
        a *= 4;
        b *= 3;
        c *= 2;

        printEquation(a, b, c, d);

        double[] rootsOfEquation = new double[4];

        int countRoots = 0;
        for(double x = -5; x <= 5; x += 0.000001){
            if(a * Math.pow(x, 3) + b * Math.pow(x, 2) + c * x + d == 0){
                rootsOfEquation[countRoots++] = x;
            }
        }

        for(int j = 1; j <= countRoots - 1; j++){
            if(rootsOfEquation[j] < rootsOfEquation[j - 1] & countRoots > 1){
                double temp = rootsOfEquation[j];
                rootsOfEquation[j] = rootsOfEquation[j - 1];
                rootsOfEquation[j - 1] = temp;
            }
        }

        System.out.print("\nКорни уравнения: ");
        if(countRoots == 1)
            System.out.printf("x₁ = %d\n", rootsOfEquation[0]);
        if(countRoots == 2)
            System.out.printf("x₁ = %d, x₂ = %d\n", rootsOfEquation[0], rootsOfEquation[1]);
        if(countRoots == 3)
            System.out.printf("x₁ = %d, x₂ = %d, x₃ = %d\n", rootsOfEquation[0], rootsOfEquation[1], rootsOfEquation[2]);

        char negativeInfinity = '+';
        if(a * Math.pow(-100, 3) + b * Math.pow(-100, 2) + c * -100 + d < 0)
            negativeInfinity = '-';

        char positiveInfinity = '+';
        if(a * Math.pow(100, 3) + b * Math.pow(100, 2) + c * 100 + d < 0)
            negativeInfinity = '-';

        char x1 = '+';
        char x2 = '+';
        char x3 = '+';

        System.out.print("\n  x | -∞ | ");
        switch(countRoots){
            case 1:
                if(a * Math.pow(rootsOfEquation[0], 3) + b * Math.pow(rootsOfEquation[0], 2) + c * rootsOfEquation[0] + d < 0)
                    x1 = '-';

                System.out.printf("%d | ", rootsOfEquation[0]);
                break;
            case 2:
                if(a * Math.pow(rootsOfEquation[0], 3) + b * Math.pow(rootsOfEquation[0], 2) + c * rootsOfEquation[0] + d < 0)
                    x1 = '-';
                if(a * Math.pow(rootsOfEquation[1], 3) + b * Math.pow(rootsOfEquation[1], 2) + c * rootsOfEquation[1] + d < 0)
                    x2 = '-';

                System.out.printf("%d | ", rootsOfEquation[0]);
                System.out.printf("%d | ", rootsOfEquation[1]);
                break;
            case 3:
                if(a * Math.pow(rootsOfEquation[0], 3) + b * Math.pow(rootsOfEquation[0], 2) + c * rootsOfEquation[0] + d < 0)
                    x1 = '-';
                if(a * Math.pow(rootsOfEquation[1], 3) + b * Math.pow(rootsOfEquation[1], 2) + c * rootsOfEquation[1] + d < 0)
                    x2 = '-';
                if(a * Math.pow(rootsOfEquation[2], 3) + b * Math.pow(rootsOfEquation[2], 2) + c * rootsOfEquation[2] + d < 0)
                    x3 = '-';

                System.out.printf("%d | ", rootsOfEquation[0]);
                System.out.printf("%d | ", rootsOfEquation[1]);
                System.out.printf("%d | ", rootsOfEquation[2]);
        }
        System.out.print("+∞");

        System.out.printf("\nf(x)| %c | ", negativeInfinity);
        switch(countRoots){
            case 1:
                System.out.printf("%c | ", x1);
                break;
            case 2:
                System.out.printf("%c | ", x1);
                System.out.printf("%c | ", x2);
                break;
            case 3:
                System.out.printf("%c | ", x1);
                System.out.printf("%c | ", x2);
                System.out.printf("%c | ", x3);
        }
        System.out.printf("%c", positiveInfinity);
    }
}
