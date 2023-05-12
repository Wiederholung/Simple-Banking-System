package Java.lab1;

public class DoublingNumbers {

    public void loop(int ver) {
        int i = 1;
        if (ver == 0) {
            System.out.println();
            while (i <= 10) {
                System.out.println("The double of " + i + " is " + 2*i);
                i++;
            }
            System.out.println("Ver: " + ver);
        }

        else if (ver == 1) {
            System.out.println();
            do
            {
                System.out.println("The double of " + i + " is " + 2*i);
                i++;
            } while(i <= 10);
            System.out.println("Ver: " + ver);
        }

        else if (ver == 2) {
            System.out.println();
            for(i = 1; i <= 10; i++) {
                System.out.println("The double of " + i + " is " + 2*i);
            }
            System.out.println("Ver: " + ver);
        }

        else {System.out.println("wrong ver code!");}
    }

    public static void main(String[] args) {
        DoublingNumbers n = new DoublingNumbers();
        n.loop(0);
        n.loop(1);
        n.loop(2);
    }
}