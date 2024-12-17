package model;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFileChooser;

import javax.swing.JTextArea;

import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.UnderlinePatterns;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;

public class model {
	private static final SecureRandom random = new SecureRandom();
	private BigInteger p;
	private BigInteger q;
	private BigInteger g;
	private BigInteger h;
	private BigInteger x;
	private BigInteger y;
	private BigInteger k;
	private BigInteger r;
	private BigInteger s;
	private String chuky;
	private String thongbaoloi_1;
	private String thongbaoloi_2;
    private static final int INIT_A = 0x67452301;
    private static final int INIT_B = 0xefcdab89;
    private static final int INIT_C = 0x98badcfe;
    private static final int INIT_D = 0x10325476;

    private static final int[] SHIFT_AMOUNTS = {
        7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22, 7, 12, 17, 22,
        5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20, 5, 9, 14, 20,
        4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23, 4, 11, 16, 23,
        6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21, 6, 10, 15, 21
    };

    private static final int[] TABLE_T = new int[64];
    static {
        for (int i = 0; i < 64; i++) {
            TABLE_T[i] = (int) (long) ((1L << 32) * Math.abs(Math.sin(i + 1)));
        }
    }

    public static byte[] computeMD5(byte[] message) {
        int messageLenBytes = message.length;
        int numBlocks = ((messageLenBytes + 8) >>> 6) + 1;
        int totalLen = numBlocks << 6;
        byte[] paddingBytes = new byte[totalLen - messageLenBytes];
        paddingBytes[0] = (byte) 0x80;

        long messageLenBits = (long) messageLenBytes << 3;
        for (int i = 0; i < 8; i++) {
            paddingBytes[paddingBytes.length - 8 + i] = (byte) (messageLenBits >>> (8 * i));
        }

        int[] state = {INIT_A, INIT_B, INIT_C, INIT_D};
        int[] buffer = new int[16];
        
        for (int i = 0; i < numBlocks; i++) {
            for (int j = 0; j < 16; j++) {
                buffer[j] = 0;
            }
            for (int j = 0; j < 64; j++) {
                int index = (i << 6) + j;
                if (index < messageLenBytes) {
                    buffer[j >>> 2] |= (message[index] & 0xff) << ((j % 4) * 8);
                } else {
                    buffer[j >>> 2] |= (paddingBytes[index - messageLenBytes] & 0xff) << ((j % 4) * 8);
                }
            }
            md5Transform(state, buffer);
        }

        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        byteBuffer.putInt(state[0]);
        byteBuffer.putInt(state[1]);
        byteBuffer.putInt(state[2]);
        byteBuffer.putInt(state[3]);

        return byteBuffer.array();
    }

    private static void md5Transform(int[] state, int[] block) {
        int a = state[0];
        int b = state[1];
        int c = state[2];
        int d = state[3];

        for (int i = 0; i < 64; i++) {
            int f, g;
            if (i < 16) {
                f = (b & c) | (~b & d);
                g = i;
            } else if (i < 32) {
                f = (d & b) | (~d & c);
                g = (5 * i + 1) % 16;
            } else if (i < 48) {
                f = b ^ c ^ d;
                g = (3 * i + 5) % 16;
            } else {
                f = c ^ (b | ~d);
                g = (7 * i) % 16;
            }
            int temp = d;
            d = c;
            c = b;
            b = b + Integer.rotateLeft(a + f + block[g] + TABLE_T[i], SHIFT_AMOUNTS[i]);
            a = temp;
        }

        state[0] += a;
        state[1] += b;
        state[2] += c;
        state[3] += d;
    }
    public static BigInteger oclit(BigInteger r0, BigInteger r1) {
		if(r0.gcd(r1).equals(BigInteger.ONE)) {
		BigInteger[] q = new BigInteger[100];
		BigInteger[] s = new BigInteger[100];
		BigInteger[] t = new BigInteger[100];
        BigInteger r2 = new BigInteger("-1");
        int i = 0;
        
        while(!r2.equals(BigInteger.ZERO))
        {
        	r2 = r0.mod(r1);
        	q[i+1] = r0.divide(r1);
        	
        	if(i==0) {
        		s[i] = BigInteger.ONE;
        		t[i] = BigInteger.ZERO;
        	}else if(i==1) {
        		s[i] = BigInteger.ZERO;
        		t[i] = BigInteger.ONE;
        	}else 
        	{
        		s[i] = s[i-2].subtract(s[i-1].multiply(q[i-1]));
        		t[i] = t[i-2].subtract(t[i-1].multiply(q[i-1]));
        	}
        	r0 = r1;
        	r1 = r2;
        	i++;
        }
        s[i] = s[i-2].subtract(s[i-1].multiply(q[i-1]));
		t[i] = t[i-2].subtract(t[i-1].multiply(q[i-1]));
		
        if(t[i].compareTo(BigInteger.ZERO)<0) {
        	return t[i].add(r0);
        }
        return t[i];
		}else {
			return new BigInteger("-1");
		}
    }

	public String getThongbaoloi_2() {
		return thongbaoloi_2;
	}
	public void setThongbaoloi_2(String thongbaoloi_2) {
		this.thongbaoloi_2 = thongbaoloi_2;
	}

	private String bamMD5;
	private String bam_2;
	
	public BigInteger getR() {
		return r;
	}
	public void setR(BigInteger r) {
		this.r = r;
	}
	public BigInteger getS() {
		return s;
	}
	public void setS(BigInteger s) {
		this.s = s;
	}
	public model() {
		
	}

	public static BigInteger squareAndMultiply(BigInteger base, BigInteger exponent, BigInteger modulus) {
        BigInteger result = BigInteger.ONE;
       base = base.mod(modulus);
       ArrayList<BigInteger> arrayList = new ArrayList<>();
       BigInteger binary = exponent;
   	   while(!binary.equals(BigInteger.ZERO)){
   		   arrayList.add(binary.mod(BigInteger.ONE.add(BigInteger.ONE)));
           binary = binary.divide(BigInteger.ONE.add(BigInteger.ONE));
   	   }
   	   int size = arrayList.size();
       
       for(int j = size -1 ; j >= 0 ; j --) {
    	   result = (result.multiply(result)).mod(modulus);
    	   if(arrayList.get(j).equals(BigInteger.ONE)) {
    		   result = (result.multiply(base)).mod(modulus); 
    	   }
       }
        return result;
    }
//	public static  BigInteger squareAndMultiply(BigInteger x, BigInteger n , BigInteger m) {
//		// Initialize result
//		BigInteger result = squareAndMultiply(x, n.multiply(BigInteger.TWO), m);
//		
//		// Ensure base is in the range [0, modulus-1]
//		
//		x = x.mod(m);
//		
//		
//		
//		
//	}
	public void mofile(JTextPane jp) {
		 try {
	            // Thiết lập Look and Feel cho JFileChooser để phù hợp với hệ thống
	            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
	            e.printStackTrace();
	        }
		// Hiển thị hộp thoại chọn tệp
	        JFileChooser fileChooser = new JFileChooser();
	        int returnValue = fileChooser.showOpenDialog(null);
	        //kiểm tra xem có mở file hay không thông qua giá trị returnValue
	        if(returnValue==JFileChooser.APPROVE_OPTION) {
	        	File file = fileChooser.getSelectedFile();
	        	if(file.getName().endsWith(".txt")) {
	        		try {
	        			//thiết lập có thể chỉnh sửa
	        			List<String> listText = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
						String result="";
						for(int i = 0 ; i < listText.size() ; i++) {
							result+=listText.get(i);
							if(i < listText.size() - 1) {
								result+="\n";
							}
						} 
						jp.setText(result);
						
					} catch ( IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	        	}
	        	if(file.getName().endsWith(".docx")){
	        		jp.setEditable(true);
	        	    jp.setText(""); // Xóa nội dung hiện tại
	        	    // Lấy đường dẫn file được chọn
	        	    String filePath = file.getPath();
	        	    try (FileInputStream fis = new FileInputStream(filePath);
	        	         XWPFDocument document = new XWPFDocument(fis)) {

	        	        // Lấy danh sách các đoạn văn trong tài liệu
	        	        List<XWPFParagraph> paragraphs = document.getParagraphs();
	        	        StyledDocument styledDoc = jp.getStyledDocument();

	        	        // Xử lý từng đoạn văn và thêm vào JTextPane
	        	        for (XWPFParagraph para : paragraphs) {
	        	            // Lấy kiểu căn lề của đoạn văn
	        	            ParagraphAlignment alignment = para.getAlignment();
	        	            int styleAlignment;
	        	            switch (alignment) {
	        	                case CENTER:
	        	                    styleAlignment = StyleConstants.ALIGN_CENTER;
	        	                    break;
	        	                case RIGHT:
	        	                    styleAlignment = StyleConstants.ALIGN_RIGHT;
	        	                    break;
	        	                case BOTH:
	        	                case DISTRIBUTE:
	        	                    styleAlignment = StyleConstants.ALIGN_JUSTIFIED;
	        	                    break;
	        	                case LEFT:
	        	                default:
	        	                    styleAlignment = StyleConstants.ALIGN_LEFT;
	        	                    break;
	        	            }

	        	            MutableAttributeSet paragraphAttributes = new SimpleAttributeSet();
	        	            StyleConstants.setAlignment(paragraphAttributes, styleAlignment);

	        	            // Thêm đoạn văn vào StyledDocument
	        	            styledDoc.setParagraphAttributes(styledDoc.getLength(), 1, paragraphAttributes, false);

	        	            List<XWPFRun> runs = para.getRuns();
	        	            for (XWPFRun run : runs) {
	        	                String text = run.getText(0);
	        	                if (text != null) {
	        	                    MutableAttributeSet attr = new SimpleAttributeSet();
	        	                    StyleConstants.setBold(attr, run.isBold());
	        	                    StyleConstants.setItalic(attr, run.isItalic());

	        	                    // Kiểm tra và thiết lập màu chữ nếu có
	        	                    if (run.getColor() != null) {
	        	                        StyleConstants.setForeground(attr, Color.decode("#" + run.getColor()));
	        	                    }

	        	                    // Kiểm tra và thiết lập gạch chân nếu có
	        	                    if (run.getUnderline() != UnderlinePatterns.NONE) {
	        	                        StyleConstants.setUnderline(attr, true);
	        	                    }

	        	                    // Kiểm tra và thiết lập số mũ hoặc chỉ số dưới
	        	                    CTRPr ctrPr = run.getCTR().getRPr();
	        	                    if (ctrPr != null) {
	        	                        List<CTVerticalAlignRun> vertAlignRuns = ctrPr.getVertAlignList();
	        	                        if (vertAlignRuns != null && !vertAlignRuns.isEmpty()) {
	        	                            for (CTVerticalAlignRun vertAlign : vertAlignRuns) {
	        	                                if (vertAlign.getVal() != null) {
	        	                                    if (vertAlign.getVal().intValue() == 2) { // superscript
	        	                                        StyleConstants.setSuperscript(attr, true);
	        	                                    } else if (vertAlign.getVal().intValue() == 1) { // subscript
	        	                                        StyleConstants.setSubscript(attr, true);
	        	                                    }
	        	                                }
	        	                            }
	        	                        }
	        	                    }

	        	                    // Thêm văn bản vào StyledDocument
	        	                    styledDoc.insertString(styledDoc.getLength(), text, attr);
	        	                }
	        	            }
	        	            styledDoc.insertString(styledDoc.getLength(), "\n", null);
	        	        }
	        	    } catch (IOException | javax.swing.text.BadLocationException e) {
	        	        e.printStackTrace();
	        	    }
	        	}
	        }
	}
	public void luufile(JTextPane jp) {
		try {
            // Thiết lập Look and Feel cho JFileChooser để phù hợp với hệ thống
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
		// Hiển thị hộp thoại chọn tệp
        JFileChooser fileChooser = new JFileChooser();
        String data = jp.getText();
        String defaultFileName = "chu_ký_"+data.substring(1,6)+".txt";
        File defaultFile = new File(defaultFileName);
        fileChooser.setSelectedFile(defaultFile);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showSaveDialog(null);

        if(returnValue == JFileChooser.APPROVE_OPTION) {
        	try {
				File file = fileChooser.getSelectedFile();
				PrintWriter pw = new PrintWriter(file.getAbsolutePath(),"UTF-8");
				
				pw.print(data);
				pw.flush();
				pw.close();
			} catch (Exception e) {
				// TODO: handle exception
			}
        }
	}
	//phương thức hàm băm 
	public String bam(String input) {
		String result =null;
		try {
			byte[] messageDigest = computeMD5(input.getBytes());
		    BigInteger bigInt = new BigInteger(1,messageDigest);
		    result = bigInt.toString(16);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return result;
	}
	public static BigInteger generatePrime(BigInteger lowerBound, BigInteger upperBound) {
        while (true) {
            BigInteger p = new BigInteger(upperBound.bitLength(), random);
            if (p.compareTo(lowerBound) > 0 && p.compareTo(upperBound) < 0 && p.isProbablePrime(100)) {
                return p;
            }
        }
    }	
	private static BigInteger[] findPandQ(int[] L_values, BigInteger lowerBoundQ, BigInteger upperBoundQ) {
        for (int L : L_values) {
            BigInteger lowerBoundP = BigInteger.valueOf(2).pow(L - 1);
            BigInteger upperBoundP = BigInteger.valueOf(2).pow(L);

            while (true) {
                BigInteger q =generatePrime(lowerBoundQ, upperBoundQ);
                BigInteger kLower = lowerBoundP.subtract(BigInteger.ONE).divide(q).add(BigInteger.ONE);
                BigInteger kUpper = upperBoundP.subtract(BigInteger.ONE).divide(q);

                for (BigInteger k = kLower; k.compareTo(kUpper) <= 0; k = k.add(BigInteger.ONE)) {
                    BigInteger p = k.multiply(q).add(BigInteger.ONE);
                    if (p.isProbablePrime(100)) {
                        return new BigInteger[]{p, q};
                    }
                }
            }
        }
        return null; // Khi không tìm được cặp p và q thỏa mãn
	}

	//Phương thúc dùng sinh khóa ngẫu nhiên p , q ,h
	public void sinhkhoa() {
		 int[] L_values = {512, 576, 640, 704, 768, 832, 896, 960, 1024};
	        int bitLengthQ = 160;
	        BigInteger lowerBoundQ = BigInteger.valueOf(2).pow(bitLengthQ - 1);
	        BigInteger upperBoundQ = BigInteger.valueOf(2).pow(bitLengthQ).subtract(BigInteger.ONE);

	        BigInteger[] result = findPandQ(L_values, lowerBoundQ, upperBoundQ);
	         p = result[0];
	         q = result[1];

	    int length_h = (int)(1+Math.random()*510);
	    h = new BigInteger(length_h, new Random());
	    
	    while(squareAndMultiply(h, (p.subtract(BigInteger.ONE)).divide(q), p).compareTo(BigInteger.ONE)<=0) {
	    	h = new BigInteger(length_h, new Random());
	     }
	    
	    int length_x = (int)(Math.random()*510);
	    x = new BigInteger(length_x, new Random());

	     g = squareAndMultiply(h, (p.subtract(BigInteger.ONE)).divide(q), p);
	     
	     
	     
	     y = squareAndMultiply(g, x, p);
	     
	     k = new BigInteger(length_x, new Random());
		
	}
	
	
	
	
	
	

	public void thuchienky(JTextArea q,JTextArea p,JTextArea k,JTextArea h,JTextArea x,JTextPane vanbansinh) {
		
		try {
			this.q = new BigInteger(q.getText());
		    this.p = new BigInteger(p.getText());
		    this.k = new BigInteger(k.getText());
		    this.h = new BigInteger(h.getText());
		    this.x = new BigInteger(x.getText());
		    
		    g= squareAndMultiply(this.h, (this.p.subtract(BigInteger.ONE)).divide(this.q), this.p);
		    
			thongbaoloi_1="";
			
		    r = squareAndMultiply(g, this.k, this.p).mod(this.q);
		    
		    bamMD5 = this.bam(vanbansinh.getText());
		    BigInteger bigIntegermd5 = new BigInteger(bamMD5,16);
		    
		    
		    BigInteger moduloK = oclit(this.getQ(), this.k);
		    
		    s = (moduloK.multiply((bigIntegermd5.add(this.x.multiply(r))))).mod(this.q);
		    
		     chuky="";
		    chuky+="(";
		    chuky+=r.toString();
		    chuky+=",";
		    chuky+=s.toString();
		    chuky+=")";		    
		} catch (Exception e) {
			
			// TODO: handle exception
			thongbaoloi_1 = "Nhập thiếu hoặc sai định dạng";
		}	
	}
	public String getBamMD5_2() {
		return bam_2;
	}
	public void setBamMD5_2(String bamMD5_2) {
		this.bam_2 = bamMD5_2;
	}
	public void kiemtra(JTextArea q,JTextArea p,JTextArea h,JTextArea y,JTextPane vanbanky,JTextPane chuky) {
			bam_2 = this.bam(vanbanky.getText());
		    BigInteger bigIntegermd5_2 = new BigInteger(bam_2,16);
		    
		    int index = chuky.getText().indexOf(",");
		    if(index==-1) {
         	thongbaoloi_1 = "chữ ký sai định dạng hoặc nhập thiếu các giá trị";
		 }else {
			 	try {
		
			this.q = new BigInteger(q.getText());
		    this.p = new BigInteger(p.getText());
		    this.h = new BigInteger(h.getText());
		    this.y = new BigInteger(y.getText());
		    
		    
		    g= squareAndMultiply(this.h, (this.p.subtract(BigInteger.ONE)).divide(this.q), this.p);
		    
		    BigInteger r_phay = new BigInteger(chuky.getText().substring(1,index));
		    
		    BigInteger s_phay = new BigInteger(chuky.getText().substring(index+1,chuky.getText().length()-1));
		    
		    BigInteger w = oclit(this.q, s_phay);
		    
		    BigInteger u1 = (bigIntegermd5_2.multiply(w)).mod(this.q);
		    
		    BigInteger u2 =  r_phay.multiply(w).mod(this.q);
		    
		    BigInteger gu1 = squareAndMultiply(g, u1, this.p);
		    
	        BigInteger yu2=squareAndMultiply(this.y, u2, this.p);
	        
	        BigInteger v = ((gu1.multiply(yu2)).mod(this.p)).mod(this.q);
		     
		    if(v.compareTo(r_phay)==0) {
		    	thongbaoloi_1 = "chữ ký đúng!";
		    }else {
		    	thongbaoloi_1 = "chữ ký giả mạo!";
		    }
		   
		} catch (Exception e) {
			// TODO: handle exception
			thongbaoloi_1 = "chữ ký sai định dạng hoặc các giá trị sai định dạng";
		}
		}
		 try {
			 if(bamMD5.equals(bam_2)) {
		    	thongbaoloi_2 = "văn bản không bị sửa đổi";
		    }else {
		    	thongbaoloi_2 = "   Văn bản bị sửa đổi";
		    }
		} catch (Exception e) {
			// TODO: handle exception
			
		}
	       
	}
	public String getChuky() {
		return chuky;
	}
	public void setChuky(String chuky) {
		this.chuky = chuky;
	}
	public String getThongbaoloi_1() {
		return thongbaoloi_1;
	}
	public void setThongbaoloi_1(String thongbaoloi_1) {
		this.thongbaoloi_1 = thongbaoloi_1;
	}
	public String getBamMD5() {
		return bamMD5;
	}
	public void setBamMD5(String bamMD5) {
		this.bamMD5 = bamMD5;
	}
	public BigInteger getK() {
		return k;
	}
	public void setK(BigInteger k) {
		this.k = k;
	}
	public String convert(BigInteger b) {
		
		
		try {
			return b.toString();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "";
	}
	
	

	public BigInteger getP() {
		return p;
	}

	public void setP(BigInteger p) {
		this.p = p;
	}

	public BigInteger getQ() {
		return q;
	}

	public void setQ(BigInteger q) {
		this.q = q;
	}

	public BigInteger getG() {
		return g;
	}

	public void setG(BigInteger g) {
		this.g = g;
	}

	public BigInteger getH() {
		return h;
	}

	public void setH(BigInteger h) {
		this.h = h;
	}

	public BigInteger getX() {
		return x;
	}

	public void setX(BigInteger x) {
		this.x = x;
	}

	public BigInteger getY() {
		return y;
	}

	public void setY(BigInteger y) {
		this.y = y;
	}

}
