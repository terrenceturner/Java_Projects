/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cosc602_pb1_tsturner0;

import java.util.Random;

/**
 *
 * @author terrenceturner
 */
public class Booking {
   public static void main(String[] args) {
		Theater th=new Theater();
		Random rand=new Random(System.nanoTime());
		int request_seats;
		th.show_seats(); 
		while(true) {
		
			request_seats=rand.nextInt(5)+1;
			System.out.println("Requesting "+request_seats+" seats to book...");
			if(th.book_seats(request_seats)){
				System.out.println("Congrats!!! "+request_seats+" seats are booked!!!");
			}
			else{
				System.out.println("Request for "+request_seats+" seats are failed...");
			}
			th.show_seats();

			if (th.isTheatreFull()) {
				System.out.println("Theatre is full");
				break;				
			}

			if (th.isExceedConsecutiveFailedAttempts()) {
				System.out.println("10 consecutive requests are denied");
				break;				
			}

		}
		th.stats();
	}

    
}
