package Demo.Problems;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class NumberConversion {
	static int j,i;
	public static void main(String[] args) {
		System.out.println("\n\t\t\tNumber Conversion");
		System.out.println("\n\t1.Decimal Conversion\n\t2.Binary Conversion\n\t3.Octal Conversion\n\t4.HexaDecimal Conversion");
		NumberConversion nc = new NumberConversion();
		nc.NC();		   
	}
	public void NC() {
		NumberConversion nc = new NumberConversion();
		Scanner sc = new Scanner(System.in);
		System.out.println("\n\nEnter the Options : ");
		int con=0;
		while(true) {
			if(con>4||con<0) {
				System.out.println("\n\nEnter the Options : ");
			continue;
			}
			con = sc.nextInt();
			break;
		}
		switch (con) {
		case 1:
			   System.out.println("\n\nEnter the decimal number:");
			   int dec =  sc.nextInt();
			   System.out.println( "Decimal to binary : " +nc.dec2bin(dec));
			   System.out.println( "Decimal to octal : " +nc.dec2oct(dec));
			   System.out.println( "Decimal to hexaDecimal : " +nc.dec2hex(dec));
			   NC();
			   break;
		case 2:
			System.out.println("\n\nEnter the binary number:");
			   Long bin =  sc.nextLong();
			   System.out.println( "Binary to decimal : " +nc.bin2dec(bin));
			   System.out.println( "Binary to octal : " +nc.bin2oct(bin));
			   System.out.println( "Binary to hexaDecimal : " +nc.bin2hex(bin));
			   NC();
		case 3:
			System.out.println("\n\nEnter the octal number:");
			   int oct =  sc.nextInt();
			   System.out.println( "Octal to decimal : " +nc.oct2dec(oct));
			   System.out.println( "Octal to octal : " +nc.oct2bin(oct));
			   System.out.println( "Octal to hexaDecimal : " +nc.oct2hex(oct));
			   NC();
		case 4:
			System.out.println("\n\nEnter the hexa number:");
			   String hex =  sc.next();
			   System.out.println( "Hexa to decimal : " +nc.hex2dec(hex.toUpperCase()));
			   System.out.println( "Hexa to decimal : " +nc.hex2bin(hex.toUpperCase()));
			   System.out.println( "Hexa to decimal : " +nc.hex2oct(hex.toUpperCase()));
			   
			   NC();
	   
		default:
			break;
		}
	}
	
	private int hex2dec(String hex) {
		String [] arr = new String[] {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};	
		int length=hex.length();
		int dec = 0;
	  int num =0;
		for(int k=0,i=length-1;i>=0;i--,k++) {
			for(int j=0;j<16;j++) {
				if(arr[j].equals(hex.substring(i,i+1))) {
					num=j;
					break;
				}
			}
			dec+=(int) (num*Math.pow(16, k));
		}
		return dec;
	}
	private String hex2bin(String hex) {
	int dec = hex2dec(hex);
		return dec2bin(dec);
	}
	private String hex2oct(String hex) {
		int dec = hex2dec(hex);
		return dec2oct(dec);
	}
	public int oct2dec(int oct) {
		String str = String.valueOf(oct);
	     int i,mod;
	     int dec=0;
	     int length= str.length();
	     for(i=0;i<length;i++){
	         mod = oct%10;
	         dec=(int)Math.pow(8,i)*mod+dec;
	         oct=(int)oct/10;
	       }
	     return dec;
	}
	public int oct2bin(int oct) {

	     int i=0,dec=0;
		  while (oct != 0) {
	          dec+= (oct % 10) * Math.pow(8, i);
	          ++i;
	          oct /= 10;
	}
		  return Integer.parseInt(dec2bin(dec));
		  
}
	public String oct2hex(int oct) {
          int bin = oct2bin(oct);
          
		  return bin2hex(Long.parseLong(String.valueOf(bin)));
		  
}
	
    
	public int bin2dec(Long bin) {
		int length=String.valueOf(bin).length();
		int dec=0;
		Long num=0l;
	     for(i=0;i<length;i++){
	         num= bin%10;
	         dec+=(int)Math.pow(2,i)*num;
	         bin=bin/10;
	       }
		return dec;
	}
	public int bin2oct(Long bin) {
		int length=String.valueOf(bin).length();
		String oct = "";
		String octal="";
		if(length%3==0) {
			while(bin!=0) {
			Long num = bin%1000;
			oct+=String.valueOf(bin2dec(num));
			bin=bin/1000;
			}
			for(int i=oct.length()-1;i>=0;i--) {
				octal+=oct.charAt(i);
			}
		}
		else if(length%3==1) {
			String bstr = "0"+bin;
			bin=Long.parseLong(bstr);
			while(bin!=0) {
			Long num = bin%1000;
			oct+=String.valueOf(bin2dec(num));
			bin=bin/1000;
			}
			for(int i=oct.length()-1;i>=0;i--) {
				octal+=oct.charAt(i);
			}
		}
		else if(length%3==2) {
			String bstr = "00"+bin;
			bin=Long.parseLong(bstr);
			while(bin!=0) {
			Long num = bin%1000;
			oct+=String.valueOf(bin2dec(num));
			bin=bin/1000;
			}
			
			for(int i=oct.length()-1;i>=0;i--) {
				octal+=oct.charAt(i);
			}
		}
		return Integer.parseInt(octal);
	       }
		
	
	public String bin2hex(Long bin) {
		String [] arr = new String[] {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		int length=String.valueOf(bin).length();
		String hex = "";
		String hexa="";
		if(length%4==0) {
			while(bin!=0) {
			Long num = bin%10000;
			hex+=arr[bin2dec(num)];
			bin=bin/10000;
			}
			for(int i=hex.length()-1;i>=0;i--) {
				hexa+=hex.charAt(i);
			}
		}
		else if(length%4==1) {
			String bstr = "0"+bin;
			bin=Long.parseLong(bstr);
			while(bin!=0) {
			Long num = bin%10000;
			hex+=arr[bin2dec(num)];
			bin=bin/10000;
			}
			for(int i=hex.length()-1;i>=0;i--) {
				hexa+=hex.charAt(i);
			}
		}
		else if(length%4==2) {
			String bstr = "00"+bin;
			bin=Long.parseLong(bstr);
			while(bin!=0) {
			Long num = bin%10000;
			hex+=arr[bin2dec(num)];
			bin=bin/10000;
			}
			for(int i=hex.length()-1;i>=0;i--) {
				hexa+=hex.charAt(i);
			}
		}
		else if(length%4==3) {
			String bstr = "00"+bin;
			bin=Long.parseLong(bstr);
			while(bin!=0) {
			Long num = bin%10000;
			hex+=arr[bin2dec(num)];
			bin=bin/10000;
			}
			for(int i=hex.length()-1;i>=0;i--) {
				hexa+=hex.charAt(i);
			}
		}
		return hexa;
	}
	
	public String dec2bin(int dec) {
		List <Integer> binary = new ArrayList<>();
		   
		   String bstr="";
		  
		   while (dec!=0){
		     binary.add(dec%2);
		     dec=dec/2;
		     }
		     for (j=binary.size()-1;j>=0;j--){
		      bstr+= binary.get(j)+"";
		      }
			return bstr;
	}
	public String dec2oct(int oct) {
		List<Integer> octal = new ArrayList<>();
		
		   
		   String octstr="";
		   while (oct!=0){
		     octal.add(oct%8);
		     oct=oct/8;
		     }
		     for (j=octal.size()-1;j>=0;j--){
		      octstr+= octal.get(j)+"";
		      
		      }
		     
			return octstr;
	}
	public String dec2hex(int hex) {
		List<String> hexa = new ArrayList<>();
		String [] arr = new String[] {"0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F"};
		   String hexstr="";
		  int i = 0;
		   
		   while (hex!=0){
			   i=hex%16;
		       hexa.add(arr[i]);
		       hex=hex/16;
		     }
		     for (j=hexa.size()-1;j>=0;j--){
		      hexstr+= hexa.get(j)+"";
		      }
		     
			return hexstr;
	}	
}


