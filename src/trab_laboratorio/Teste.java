package trab_laboratorio;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
	
	public static void menu() {
		System.out.println("\n\n*******************************************************");
		System.out.println("\tWELCOME TO REGISTER OF CALLS");
		System.out.println("*******************************************************");
		System.out.println("[1] - Add new Client");
		System.out.println("[2] - Remove a Client");
		System.out.println("[3] - Changes owners data of Client");
		System.out.println("[4] - Search Client by his number");
		System.out.println("[5] - Search Client by any expiry of his name");
		System.out.println("[6] - Insert a call on call client list");
		System.out.println("[7] - Print data of a Client");
		System.out.println("[8] - Build and print invoice of a Client");
		System.out.println("[9] - Export invoice of a Client to .txt file");
		System.out.println("[10] - Exit\n");
	}
	
	
	private static ArrayList<Client> clientList;
	private static Client client;
	private static Calls call;
	
	private static int numClient = 0; // number of client
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Scanner scNum = new Scanner(System.in);
		boolean sair = false;
		
		clientList = new ArrayList<>();
		
		while (!sair) {
			
			menu(); // call the method menu to show our menu
			System.out.print("Input: ");
			int opt = scNum.nextInt();
			
			if (opt == 1) {
				client = new Client();
				
				String name = null;
				String address = null;
				String phoneNumber = null;
				
				System.out.println("************************************");
				System.out.println("\tADD NEW CLIENT");
				System.out.println("************************************");
				
				System.out.print("Client name: ");
				name = scan.nextLine();
				client.setName(name);
				
				System.out.print("Client address: ");
				address = scan.nextLine();
				
				// verify if address type if one String
				while (true) {
					try {
						Integer.valueOf(address);
						System.out.print("Client address is String type: ");
						address = scan.nextLine();
					} catch (NumberFormatException n) {
						break;
					}
				}
				client.setAddress(address);
				
				while (true) {					
					
					try {
						System.out.print("Client phone number: ");
						phoneNumber = scan.nextLine();
						Long.valueOf(phoneNumber);
						break;
					} catch (Exception e) {
						System.out.println("Number inserted is invalid.");
					}
				}
				
				client.setPhoneNumber(phoneNumber);
				
				numClient += 1; // incremment numClient
				client.setNumClient(numClient);
				
				clientList.add(client);
					
			} else if (opt == 2) {
				System.out.print("Insert number of client to delete: ");
				int numClient = scNum.nextInt();
				try {
					if (numClient <= clientList.size()) {						
						System.out.println("You are trying delete client: "+clientList.get(numClient - 1).getName());
						clientList.remove(numClient - 1);
					}
				} catch (IndexOutOfBoundsException e) {
					System.out.println("An error was ocurred: "+e.getMessage());
				}
			} else if(opt == 3) {
				System.out.print("Insert number of client to search: ");
				int numClient = scNum.nextInt();
				
				if (numClient <= clientList.size()) {
					Client cl = clientList.get(numClient - 1);
					
					System.out.println("[1] - Name");
					System.out.println("[2] - Address");
					System.out.println("[3] - Phone Number");
					System.out.print("What you wanna update? ");
					int opt2 = scNum.nextInt();
					
					if (opt2 == 1) {
						System.out.print("Insert new name to client: ");
						String name = scan.nextLine();
						cl.setName(name);
					} else if (opt2 == 2) {
						System.out.print("Insert new address to client: ");
						String address = scan.nextLine();
						// verify if address type if one String
						while (true) {
							try {
								Integer.valueOf(address);
								System.out.print("Client address is String type: ");
								address = scan.nextLine();
							} catch (NumberFormatException n) {
								break;
							}
						}
						cl.setAddress(address);
					} else if (opt2 == 3) {
						while (true) {					
							try {
								System.out.print("Client phone number: ");
								String phoneNumber = scan.nextLine();
								Long.valueOf(phoneNumber);
								cl.setPhoneNumber(phoneNumber);
								break;
							} catch (Exception e) {
								System.out.println("Number inserted is invalid.");
							}
						}
					}
				} else {
					System.out.println("This client doesn't exists.");
				}
			} else if (opt == 4) {
				System.out.print("Insert number of client to search: ");
				int numClient = scNum.nextInt();
				boolean existe = false;
				for (Client c: clientList) {
					if (c.getNumClient() == numClient) {
						System.out.println("Client exists and his name is "+c.getName());
						existe = true;
						break;
					}
				}
				if (!existe) {
					System.out.println("This client doesn't exists.");
				}
			} else if(opt == 5) {
				System.out.print("Insert any expiry of name of client to search: ");
				String nameClient = scan.nextLine();
				boolean existe = false;
				for (Client c: clientList) {
					if (c.getName().contains(nameClient)) {
						System.out.println("Client exists and his name is "+c.getName());
						existe = true;
						break;
					}
				}
				if (!existe) {
					System.out.println("This client doesn't exists.");
				}
			} else if (opt == 6) {
				call = new Calls();
				
				System.out.println("**********************************************");
				System.out.println("\tADD NEW Call ON CALL CLIENT LIST");
				System.out.println("**********************************************");
				
				System.out.print("Client Number: ");
				int clientNumber = scNum.nextInt();
				
				System.out.print("Phone Number Destination: ");
				String numPhoneDestination = scan.next();
				
				System.out.print("Call Type[F-fixed, I-international, P-phone]: ");
				String callType = scan.next().toUpperCase();
				
				System.out.print("Call Duration: ");
				double callDuration = scNum.nextDouble();
				
				call.setNumPhoneDestination(numPhoneDestination);
				char cType = (char) callType.charAt(0);
				call.setCallType(String.valueOf(cType));
				call.setCallDuration(callDuration);
				
				clientList.get(clientNumber - 1).setCallsList(call);
			} else if (opt == 7) {
				System.out.print("Insert number of client to show: ");
				int numClient = scNum.nextInt();
				
				if (numClient <= clientList.size())
					System.out.println(clientList.get(numClient - 1).toString());
				else
					System.out.println("This client doesn't exists.");
				
			} else if (opt == 8) {
				System.out.print("Insert number of client to show: ");
				int numClient = scNum.nextInt();
				
				if (numClient <= clientList.size()) {
					System.out.println("Name................: "+clientList.get(numClient - 1).getName());
					System.out.println("Phone Number........: "+clientList.get(numClient - 1).getPhoneNumber());
					System.out.println("Calls List..........: "+clientList.get(numClient - 1).getCallsList());
					System.out.printf("Total Price to pay..: %.2f STN\n",clientList.get(numClient - 1).calculatePrice());
				}
				else
					System.out.println("This client doesn't exists.");
			} else if (opt == 9) {
				try {
					System.out.print("Insert number of client to show: ");
					int numClient = scNum.nextInt();
					
					if (numClient <= clientList.size()) {
						Client cl = clientList.get(numClient - 1);
						String filename = String.format("0%d_invoice.txt", numClient);
						FileWriter arq = new FileWriter(""+filename);
						PrintWriter saveFile = new PrintWriter(arq);
						saveFile.printf("+----------- Invoice of Client %s ---------+\n", cl.getName());
						saveFile.printf("+------------------------------------------------------+\n");
						saveFile.printf("Name..................: %s\n",cl.getName());
						saveFile.printf("Address...............: %s\n",cl.getAddress());
						saveFile.printf("Phone Number..........: %s\n",cl.getPhoneNumber());
						saveFile.printf("Calls List............: %s\n",cl.getCallsList());
						saveFile.printf("Total Price to pay....: %.2f STN\n",cl.calculatePrice());
						saveFile.printf("+------------------------------------------------------+\n");
						arq.close();
						System.out.println("Well done.");
					}
					else
						System.out.println("This client doesn't exists.");
					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			} else if (opt == 10) {
				sair = true;
				break;
			} else {
				throw new IllegalArgumentException("Unexpected value: " + opt);
			}
		}
		scan.close();
				
	}
}
