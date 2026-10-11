package problem1;
import java.util.Scanner;
public class Sales
{
    public static void main(String[] args)
    {
        int SALESPEOPLE;
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter the number of sales people: ");
        SALESPEOPLE = scan.nextInt();
        int[] sales = new int[SALESPEOPLE];
        int sum;
        int max_sales = 0;
        int min_sales = Integer.MAX_VALUE;
        int id_min = 0, id_max = 0;
        for (int i=0; i<sales.length; i++)
        {
            System.out.print("Enter sales for salesperson " + (i + 1) + ": ");
            sales[i] = scan.nextInt();
        }
        System.out.println("\nSalesperson Sales");
        System.out.println("--------------------");
        sum = 0;
        for (int i=0; i<sales.length; i++)
        {
            System.out.println(" " + (i + 1) + " " + sales[i]);
            sum += sales[i];
            if (sales[i] > max_sales) {
                max_sales = sales[i];
                id_max = i + 1;
            }
            if (sales[i] < min_sales) {
                min_sales = sales[i];
                id_min = i + 1;
            }
        }
        System.out.println("\nTotal sales: " + sum);
        double avg = sum / 5.0;
        System.out.println("The average sale:" + avg);
        System.out.println("Salesperson " + id_max + " had the highest sale with " + max_sales + "$");
        System.out.println("Salesperson " + id_min + " had the lowest sale with " + min_sales + "$");

        System.out.print("\nEnter a threshold value: ");
        int threshold = scan.nextInt();
        int countExceeded = 0;
        System.out.println("\nSalespeople who exceeded $" + threshold + ":");
        for (int i = 0; i < sales.length; i++) {
            if (sales[i] > threshold) {
                System.out.println("Salesperson " + (i + 1)+ " with " + sales[i] + "$");
                countExceeded++;
            }
        }
        System.out.println("Total number of salespeople who exceeded the value: " + countExceeded);

        scan.close();
    }
}