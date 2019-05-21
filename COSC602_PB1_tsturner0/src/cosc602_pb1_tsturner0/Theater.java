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
public class Theater {

    /**
     * @param args the command line arguments
     */
   static final int ROWS=16,COLS=11,TOTAL_SEATS=(ROWS*COLS);

	int total_reqs,failed_reqs,filled_seats,consecutive_failed_reqs=0;

	String seats[][];
	int available_seats_in_row[];

	public Theater(){

		total_reqs=0;
		failed_reqs=0;
		filled_seats=0;
		seats=new String[ROWS][COLS];

		available_seats_in_row=new int[ROWS];

		for(int i=0;i<ROWS;i++){

			available_seats_in_row[i]=COLS;

		}

		for(int i=0;i<ROWS;i++){

			for(int j=0;j<COLS;j++){

				seats[i][j]="...";

			}

		}
	}

	public void show_seats(){
			System.out.println();
 
		for(int i=0;i<=COLS;i++){
			if (i==0) {
				System.out.printf("    ");			
			}
			else{
				System.out.printf(" %3d",i);							
			}

		}
			System.out.println();
			System.out.println();

		for(int i=0;i<ROWS;i++){

			System.out.printf("%3d ",(i+1));

			for(int j=0;j<COLS;j++){

				System.out.printf("%4s",seats[i][j]);

			}

			System.out.println();

		}
			System.out.println();
			System.out.println();

	}

	public int best_row_for_requested(int requested_seats){

		int bestrow=-1,diff;
		int min_available_seats=COLS+1;
		for(int i=0;i<ROWS;i++){
			if (available_seats_in_row[i]>=requested_seats) {
				diff=available_seats_in_row[i]-requested_seats;
				if (diff<min_available_seats) {
					min_available_seats=diff;
					bestrow=i;
				}
				
			}
		}

		return bestrow;		

	}
	public boolean isExceedConsecutiveFailedAttempts(){
		return consecutive_failed_reqs==10;
	}

	public boolean isTheatreFull(){
		return filled_seats==TOTAL_SEATS;
	}

	public boolean book_seats(int requested_seats){
		int bestrow=best_row_for_requested(requested_seats);
		total_reqs++;

		if (bestrow==-1) {
			failed_reqs++;
			consecutive_failed_reqs++;
			return false;
		}
		String tmp="";
		
		if (total_reqs<10) {
			tmp="00";
		}
		else
		if (total_reqs<100) {
			tmp="0";
		}
		tmp=tmp+total_reqs;
		consecutive_failed_reqs=0;
		filled_seats+=requested_seats;
		for (int j=COLS-available_seats_in_row[bestrow];(j<COLS&&requested_seats>0) ;j++,requested_seats-- ) {

			seats[bestrow][j]=tmp;	
			available_seats_in_row[bestrow]--;	
		}

		return true;
	}
	
	public void stats(){

		System.out.println("\n\n****************OVERALL STATS****************\n\nnumber of seats in the theater: "+TOTAL_SEATS);
		System.out.println("number of seats filled: "+filled_seats);
		System.out.println("number of seats unfilled: "+(TOTAL_SEATS-filled_seats));
		System.out.println("number of requests: "+total_reqs);
		System.out.println("number of requests satisfied: "+(total_reqs-failed_reqs));
		System.out.println("number of requests denied: "+failed_reqs);
		System.out.println("\n\n");

	}

}


	

