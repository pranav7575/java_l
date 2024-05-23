import java.util.Scanner;

class MultiplicationTable {
    public synchronized void printTableOf2() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("2 * " + i + " = " + (2 * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }

    public synchronized void printTableOf5() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("5 * " + i + " = " + (5 * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class TableThread extends Thread {
    MultiplicationTable table;
    int number;

    TableThread(MultiplicationTable table, int number) {
        this.table = table;
        this.number = number;
    }

    public void run() {
        if (number == 2) {
            table.printTableOf2();
        } else if (number == 5) {
            table.printTableOf5();
        }
    }
}

class SimpleThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Count: " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class DaemonThread extends Thread {
    public void run() {
        while (true) {
            System.out.println("Daemon thread running...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class Main_16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MultiplicationTable table = new MultiplicationTable();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Create 5 threads");
            System.out.println("2. Print 2's and 5's multiplication tables using synchronized methods");
            System.out.println("3. Demonstrate daemon thread");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Creating 5 threads...");
                    for (int i = 0; i < 5; i++) {
                        new SimpleThread().start();
                    }
                    break;
                case 2:
                    System.out.println("Printing 2's and 5's multiplication tables...");
                    TableThread thread1 = new TableThread(table, 2);
                    TableThread thread2 = new TableThread(table, 5);
                    thread1.start();
                    thread2.start();
                    try {
                        thread1.join();
                        thread2.join();
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("Demonstrating daemon thread...");
                    DaemonThread daemonThread = new DaemonThread();
                    daemonThread.setDaemon(true);
                    daemonThread.start();
                    try {
                        Thread.sleep(5000); // Main thread sleeps for 5 seconds
                    } catch (InterruptedException e) {
                        System.out.println(e);
                    }
                    System.out.println("Main thread ending, daemon thread will stop.");
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
