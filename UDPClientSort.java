import java.io.*;
import java.net.*;
import java.util.Scanner;

class UDPClientSort
{
   public static void main(String args[]) throws Exception
   {
      Scanner inFromUser =
         new Scanner(System.in);
      String  n, ele;
      int i;
		 
      DatagramSocket clientSocket = new DatagramSocket();
	  
	 
      InetAddress IPAddress = InetAddress.getLocalHost();
      byte[] sendData = new byte[1024];
      byte[] receiveData = new byte[1024];
      System.out.print("Enter size of array : ");
      n = inFromUser.nextLine();
      sendData = n.getBytes();
      int num = Integer.parseInt(n.trim());
      DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
      clientSocket.send(sendPacket);
      String[] arr = new String[num];
      for(i = 0; i<num ; i++)
      {
       arr[0] = inFromUser.nextLine();
      }
      sendData = arr.getBytes();
       DatagramPacket sp = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
       clientSocket.send(sp);
      System.out.println("FROM SERVER : ");
      System.out.println("Sorted elements are =>");
      
      DatagramPacket rp = new DatagramPacket(receiveData, receiveData.length);
      clientSocket.receive(rp);
      String[] arr2 = new String(rp.getData());
      for(i = 0; i<num ; i++)
      {
      System.out.println(arr2[i] + "\t");
      }
      clientSocket.close();
   }
}
