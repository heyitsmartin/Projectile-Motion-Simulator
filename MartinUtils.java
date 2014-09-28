import hsa.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.awt.image.*;
import javax.imageio.*;
public class MartinUtils{

//PAUSE METHOD
public static void pause (int intMS){
	System.out.println("Paused for: " + intMS);
		try{
			Thread.sleep(intMS);
			}catch(InterruptedException e){
			}
			
	}
	//PRINTS THE LOGO (ML) TO SCREEN
	public static void mylogo(Console con){
		con.println("     * *   * *           *     ");
		con.println("     *  * *  *           *     ");
		con.println("     *   *   *           *     ");
		con.println("     *       *           *     ");
		con.println("     *       *           ********");		
	}
	//SOLVES THE PYTHAG THEORM
	public static double pythag(double dbla, double dblb){
		double dblc;
		
		dblc=Math.sqrt(Math.pow(dbla,2)+Math.pow(dblb,2));
		return dblc;
	}
	// RANKS NAME BASED ON RANDOM PROPERTIES OF IT
	public static int bestnamerank(String strName){
		String strInital;	
		
		strInital = strName.substring(0,1);
		
		if(strInital.equalsIgnoreCase("A")||strInital.equalsIgnoreCase("B")){
			return 9000;
		}else if(strInital.equalsIgnoreCase("J")||strInital.equalsIgnoreCase("M")){
			return 9001;
		}else{
			return 1;
		}		
	}
	//GENERATES A RANDOM NUMBER BETWEEN 1 AND 100
	public static int randint1to100(){
		int intRand;
		intRand = (int)(Math.random()*100+1);
		return intRand; 	
		
		
	}
	// FINDS THE AVG OF TWO NUMBERS
	public static double avg (double dbla, double dblb){
		double dblavg;
	
		dblavg = (dbla+dblb)/2;
	
		return dblavg;	
		
	}
	//FINDS THE VOLUME OF SPHERE
	public static double vol (double dblr){
		double dblVol;
		dblVol = dblr*(4/3)*3.1415926;
		return dblVol;
		}
		
	// CALCULATES INTRESTED BASED OF PRINCIPLE, RATE AND # OF TERMS	
	public static double intrest (double p, double r,int n){
		double dblIntrest;
		dblIntrest=(p*Math.pow((1+(r/100)),n))-p;
		return dblIntrest;
	}
	//CHECKS IF A NUMBER (INT) IS EVEN, RETURNS BOOLEAN
	public static boolean even (double dblNumber){
		boolean blnEven;
		
		if(dblNumber%2==0){
			blnEven = true; 
			return blnEven;
		}else{
			blnEven = false;
			return blnEven;
		}
			
	}
	//REVERSES A WORD
	public static String rev (Console con, String strInput){
		
			
		
		String strRev="";
		int intCount;
		

		
			
		intCount= strInput.length();
		
		
			for(;intCount>0; intCount--)
		{
			strRev=strRev+strInput.substring(intCount-1,intCount);
			
		}
		
		
		
		


	return strRev;
		
		
		
		
		
	} 
	// TRANSLATES A DATE IN NUMBER FORMAT TO WORD FORMAT EG (1,1)--> (JANUARY 1)
	public static String dayMonth(int intday, int intmonths){
		String strMonths="";
		int intdaysTotal;
		if (intmonths==1){
			strMonths = "January";
		}else if (intmonths==2){
			strMonths = "Feburary";
		}else if (intmonths==3){
			strMonths = "March";
		}else if (intmonths==4){
			strMonths = "April";
		}else if (intmonths==5){
			strMonths = "May";
		}else if (intmonths==6){
			strMonths = "June";
		}else if (intmonths==7){
			strMonths = "July";
		}else if (intmonths==8){
			strMonths = "August";
		}else if (intmonths==9){
			strMonths = "September";
		}else if (intmonths==10){
			strMonths = "October";
		}else if (intmonths==11){
			strMonths = "November";
		}else if (intmonths==12){
			strMonths = "December";
		}else{
			strMonths = "Invalid input please restart program";
		}
		return strMonths;
		
	}
	// GIVEN A DATE IN NUMBER FORMAT RETURNS WHICH DAY OF THE YEAR IT IS
	public static int daysYear(int intday, int intmonths){
			int intdaysTotal=0;
			intmonths --;
			//CHECKS IF VALID DAY
		if(intday>=1 && intday<=31){
			
			for(int intCount = intmonths;intCount >0;intCount--){	
				//DEPENDING ON THE MONTH, IT GIVES A CETAIN NUMBER OF DAYS
				if (intCount==1){
					intdaysTotal += 31;
				}else if (intCount==2){
					intdaysTotal += 28;
				}else if (intCount==3){
					intdaysTotal += 31;
				}else if (intCount==4){
					intdaysTotal += 30;
				}else if (intCount==5){
					intdaysTotal += 31;
				}else if (intCount==6){
					intdaysTotal += 30;
				}else if (intCount==7){
					intdaysTotal += 31;
				}else if (intCount==8){
					intdaysTotal += 31;
				}else if (intCount==9){
					intdaysTotal += 30;
				}else if (intCount==10){
					intdaysTotal += 31;
				}else if (intCount==11){
					intdaysTotal += 30;
				}

			}
			
			intdaysTotal=intdaysTotal + intday;
		}else{
			// L33T FOR ERROR
			intdaysTotal= 31212012;
		}
		return intdaysTotal;
	
		
	}
	//DEPENDING ON DAY OF MONTH AND MONTH, GIVES THE ZODIAC NAME
	public static String zodiac (int intDays,int intMonth){
		String strZodiac;
		 if      ((intMonth == 12 && intDays >= 22 && intDays <= 31) || (intMonth ==  1 && intDays >= 1 && intDays <= 19)){
            strZodiac=("Capricorn");
        }
        else if ((intMonth ==  1 && intDays >= 20 && intDays <= 31) || (intMonth ==  2 && intDays >= 1 && intDays <= 17)){
            strZodiac=("Aquarius");
        }
        else if ((intMonth ==  2 && intDays >= 18 && intDays <= 29) || (intMonth ==  3 && intDays >= 1 && intDays <= 19)){
            strZodiac=("Pisces");
        }
        else if ((intMonth ==  3 && intDays >= 20 && intDays <= 31) || (intMonth ==  4 && intDays >= 1 && intDays <= 19)){
            strZodiac=("Aries");
        }
        else if ((intMonth ==  4 && intDays >= 20 && intDays <= 30) || (intMonth ==  5 && intDays >= 1 && intDays <= 20)){
            strZodiac=("Taurus");
        }
        else if ((intMonth ==  5 && intDays >= 21 && intDays <= 31) || (intMonth ==  6 && intDays >= 1 && intDays <= 20)){
            strZodiac=("Gemini");
        }
        else if ((intMonth ==  6 && intDays >= 21 && intDays <= 30) || (intMonth ==  7 && intDays >= 1 && intDays <= 22)){
            strZodiac=("Cancer");
        }
        else if ((intMonth ==  7 && intDays >= 23 && intDays <= 31) || (intMonth ==  8 && intDays >= 1 && intDays <= 22)){
            strZodiac=("Leo");
        }
        else if ((intMonth ==  8 && intDays >= 23 && intDays <= 31) || (intMonth ==  9 && intDays >= 1 && intDays <= 22)){
            strZodiac=("Virgo");
        }
        else if ((intMonth ==  9 && intDays >= 23 && intDays <= 30) || (intMonth == 10 && intDays >= 1 && intDays <= 22)){
            strZodiac=("Libra");
        }
        else if ((intMonth == 10 && intDays >= 23 && intDays <= 31) || (intMonth == 11 && intDays >= 1 && intDays <= 21)){
            strZodiac=("Scorpio");
        }
        else if ((intMonth == 11 && intDays >= 22 && intDays <= 30) || (intMonth == 12 && intDays >= 1 && intDays <= 21)){
            strZodiac=("Sagittarius");
        }
        else{
	        
            strZodiac=("Invalid input, restart program");

    }
    	

    	return strZodiac;

			
	}
	
	//CHECKS IF YOU ARE COOL
	
	
	public static int coolcheck(int intdayofyear, String strmovie, int intfacefriends){
		
		
		int intCoolness = 0;
		boolean blnTrek = false;
		int intLetters;
		String strTemp;
		boolean blnFaceFriends=false;
		boolean blnDayofYear = false;
		intLetters = strmovie.length();
		//GETS LAST FOR LETTERS OF THE WORD
	 	strTemp = strmovie.substring(intLetters-4,intLetters);
		//CHECKS IF THE LAST LETTERS ARE TREK
	 	if(strTemp.equalsIgnoreCase("trek")){
			blnTrek = true;
		}
		//CHECKS IF YOUR NUMBER OF FRIENDS ARE IN THE RANGE
		if(intfacefriends>20&&intfacefriends<200){
			blnFaceFriends = true;	
		}
		//CHECKS IF YOU ARE BORN IN THE SECOND QUATER OF THE YEAR
		if(intdayofyear >=91 && intdayofyear <= 182){
			blnDayofYear = true;
		}
		
		
		if(blnTrek&&blnDayofYear&&blnFaceFriends){
			intCoolness = 2;
		}else if(blnTrek||blnDayofYear||blnFaceFriends){
			intCoolness = 1;
		}else{
			intCoolness = 0;
		}
		
		//RETURNS A COOLNESS VALUE AS A NUMBER, 0,1,2
		return intCoolness;
		
		
	}	
	
	public static int[] bubblesort1D(int intArray[]){
		int intCount;
		int intLength= intArray.length;
		int intCount1; 
		int intTemp;
		
		for( intCount = 0;intCount<intLength;intCount++){
			for(intCount1=0;intCount1<intLength-1;intCount1++){
				if(intArray[intCount1]>intArray[intCount1+1]){
					intTemp = intArray[intCount1];
					intArray[intCount1]=intArray[intCount1+1];
					intArray[intCount1+1]=intTemp;	
				}
				
			}
		}
		
		return intArray;
		
		
		
		
		
		
	} 
	//HSA CONSOLE 
	public static void print2D(Console con, String[][] strArray){
		int intRowMax = 0 ;
		int intColMax = 0 ;
		//ARRAY[row][col] 
		intRowMax = strArray.length; 
		intColMax = strArray[0].length; 
		System.out.println("intRowMax = "+intRowMax);
		System.out.println("intColMax = "+intColMax); 
		
		for( int intCounter = 0 ; intCounter< intRowMax; intCounter++) { 
			for(int intCounter2=0;intCounter2<intColMax;intCounter2++){ 
				con.print(strArray[intCounter][intCounter2]+" ") ;
			}
			con.println("");
			
		}
		
		
		
		
	} 
	

}