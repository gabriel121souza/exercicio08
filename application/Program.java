package application;
//bliblioteca
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		// usar o ponto
		Locale.setDefault(Locale.US);
                

                //funcao para ler armazenar o valores
		Scanner sc = new Scanner(System.in);
                
                //funcao para trabalhar com data
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
                //criando a lista na classe product
		List<Product> list = new ArrayList<>();
		
		//adquirindo a quantidade de produtos
                System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
    
                //for para repeti as perguntas ate a quantidade n
		for (int i=1; i<=n; i++) {
			System.out.println("Product #" + i + " data:");
			System.out.print("Common, used or imported (c/u/i)? ");
			//funcao para receber caracteres
                        char type = sc.next().charAt(0);
			System.out.print("Name: ");
                        //pulando a linha
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			//se a resposta for c 
                        if (type == 'c') {
                                //puxe a funcao Product
				list.add(new Product(name, price));
			}
                        
                            //se a resposta for u
			else if (type == 'u') {
                            // busque a classe Manufacture
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				//note que esta usando o data
                                Date date = sdf.parse(sc.next());
				list.add(new UsedProduct(name, price, date));
			}
			else {
                            // resposta for i
				System.out.print("Customs fee: ");
				double customsFee = sc.nextDouble();
				list.add(new ImportedProduct(name, price, customsFee));
			}
		}

		System.out.println();
		System.out.println("PRICE TAGS:");
                //exibir a lista prod
		for (Product prod : list) {
			System.out.println(prod.priceTag());
		}
		
		sc.close();
	}
}