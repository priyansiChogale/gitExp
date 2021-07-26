import java.io.*;
import java.net.*;
import java.util.Arrays;
class UDPServerSort
{
   public static void main(String args[]) throws Exception
      {
         DatagramSocket serverSocket = new DatagramSocket(9876);
            byte[] receiveData = new byte[1024];
            byte[] sendData = new byte[1024];
	    int i, n, ele;
            while(true)
               {
		  
                  DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                  serverSocket.receive(receivePacket);
		  System.out.println("Waiting for size of array ............ ");		  
                  String num = new String(receivePacket.getData());
                  n = Integer.parseInt(num.trim());
				  
                  System.out.println("RECEIVED size of array : " + n);
	          int[] arr = new int[n];	  
                  InetAddress IPAddress = receivePacket.getAddress();
                  int port = receivePacket.getPort();
                  System.out.println("Waiting for array elements ............ ");
                  System.out.println("Received elements => ");
                     String arr = new String(receivePacket.getData());
                  for(i = 0; i<n ; i++)
                  {
                     ar[i] = Integer.parseInt(arr[i].trim());
                     System.out.println(ar[i] + "\t");
                  }
                  System.out.println("Array getting Sorted..");
                  Arrays.sort(ar);
                  
                  String arr1 = String.valueOf(ar);
                  sendData = arr1.getBytes();  
                  DatagramPacket sendPacket =
                  new DatagramPacket(sendData, sendData.length, IPAddress, port);
                  serverSocket.send(sendPacket); }
                  System.out.println("Sorted array Sent");
               
      }
}
