package view;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.text.BadLocationException;
import javax.swing.text.Element;
import javax.swing.text.StyledDocument;

import controller.controller;
import model.model;

import java.awt.BorderLayout;

import java.awt.GridLayout;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import java.awt.Color;



public class view extends JFrame {
    private model modelview;
	public JTextArea getTextArea_p() {
		return textArea_p;
	}


	public void setTextArea_p(JTextArea textArea_p) {
		this.textArea_p = textArea_p;
	}


	public JTextArea getTextArea_q() {
		return textArea_q;
	}


	public void setTextArea_q(JTextArea textArea_q) {
		this.textArea_q = textArea_q;
	}


	public JTextArea getTextArea_x() {
		return textArea_x;
	}


	public void setTextArea_x(JTextArea textArea_x) {
		this.textArea_x = textArea_x;
	}


	public JTextArea getTextArea_h() {
		return textArea_h;
	}


	public void setTextArea_h(JTextArea textArea_h) {
		this.textArea_h = textArea_h;
	}


	public JTextArea getTextArea_y() {
		return textArea_y;
	}


	public void setTextArea_y(JTextArea textArea_y) {
		this.textArea_y = textArea_y;
	}


	public JTextArea getTextArea_k() {
		return textArea_k;
	}


	public void setTextArea_k(JTextArea textArea_k) {
		this.textArea_k = textArea_k;
	}


	public JButton getFile_vanbansinh() {
		return file_vanbansinh;
	}


	public void setFile_vanbansinh(JButton file_vanbansinh) {
		this.file_vanbansinh = file_vanbansinh;
	}


	public JButton getFile_vanbanky() {
		return file_vanbanky;
	}


	public void setFile_vanbanky(JButton file_vanbanky) {
		this.file_vanbanky = file_vanbanky;
	}


	public JButton getFile_chuky() {
		return file_chuky;
	}


	public void setFile_chuky(JButton file_chuky) {
		this.file_chuky = file_chuky;
	}


	public model getModelview() {
		return modelview;
	}


	public void setModelview(model modelview) {
		this.modelview = modelview;
	}


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea_p;
	private JTextArea textArea_q;
	private JTextArea textArea_x;
	private JTextArea textArea_h;
	private JTextArea textArea_y;
	private JTextArea textArea_k;
	private JButton button_sinhkhoa;
	private JTextField mabam_lan2;
	private JButton file_vanbansinh;
	private JButton file_vanbanky;
	private JButton file_chuky;
	private JTextPane vanban_sinh;
	private JTextPane vanbanky;
	private JTextPane chuky;
	private JTextField mabam_lan1;
	private JButton thuc_hien_ky;
	private JLabel thong_bao_1;
	private JLabel thong_bao_2;
	private JTextPane chuky_sinh;
	private JButton chuyen;
	private JButton luu;
	private JButton kiemtrachuky;

    public JTextPane getVanban_sinh() {
		return vanban_sinh;
	}


	public void setVanban_sinh(JTextPane vanban_sinh) {
		this.vanban_sinh = vanban_sinh;
	}


	public view() {
		// TODO Auto-generated constructor stub
    	modelview  = new model();
    	init();
    	this.setVisible(true);
	}
	

	/**
	 * Create the frame.
	 */
	public void init() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1339, 789);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(20, 50));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.SOUTH);
		
		button_sinhkhoa = new JButton("SinhKhoa");
		button_sinhkhoa.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(button_sinhkhoa);
		
		JPanel panel_3 = new JPanel();
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new GridLayout(3, 2, 10, 10));
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_4.add(panel_10, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Nhập p");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_10.add(lblNewLabel);
		
		JPanel panel_11 = new JPanel();
		panel_4.add(panel_11, BorderLayout.CENTER);
		panel_11.setLayout(new BorderLayout(0, 0));
		textArea_p = new JTextArea();
		//thiết lập có thể chính sửa
		textArea_p.setEditable(true);
		JScrollPane jp_p = new JScrollPane(textArea_p);
		textArea_p.setLineWrap(true);       // Bật tự động xuống dòng
		textArea_p.setWrapStyleWord(true);  // Đảm bảo xuống dòng tại các từ
		panel_11.add(jp_p, BorderLayout.CENTER);
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_12 = new JPanel();
		panel_5.add(panel_12, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập q");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_12.add(lblNewLabel_1);
		
		JPanel panel_13 = new JPanel();
		panel_5.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BorderLayout());
		textArea_q = new JTextArea();
		//thiết lập có thể chính sửa
		textArea_q.setEditable(true);
		JScrollPane jp_q = new JScrollPane(textArea_q);
		panel_13.add(jp_q, BorderLayout.CENTER);
		textArea_q.setLineWrap(true);       // Bật tự động xuống dòng
		textArea_q.setWrapStyleWord(true);  // Đảm bảo xuống dòng tại các từ
        
		
		JPanel panel_6 = new JPanel();
		panel_3.add(panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_6.add(panel_14, BorderLayout.NORTH);
		
		JLabel lblNewLabel_2 = new JLabel("Nhập h");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_14.add(lblNewLabel_2);
		
		JPanel panel_15 = new JPanel();
		panel_6.add(panel_15, BorderLayout.CENTER);
		panel_15.setLayout(new BorderLayout());
		textArea_h = new JTextArea();
		textArea_h.setEditable(true);
		
		JScrollPane jp_h = new JScrollPane(textArea_h);
		panel_15.add(jp_h, BorderLayout.CENTER);
		textArea_h.setLineWrap(true);       // Bật tự động xuống dòng
		textArea_h.setWrapStyleWord(true);  // Đảm bảo xuống dòng tại các từ
		
		JPanel panel_7 = new JPanel();
		panel_3.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_16 = new JPanel();
		panel_7.add(panel_16, BorderLayout.NORTH);
		
		JLabel lblNewLabel_3 = new JLabel("Nhập x");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_16.add(lblNewLabel_3);
		
		JPanel panel_17 = new JPanel();
		panel_7.add(panel_17, BorderLayout.CENTER);
		panel_17.setLayout(new BorderLayout());
		textArea_x = new JTextArea();
		//thiết lập có thể chính sửa
		textArea_x.setEditable(true);
		JScrollPane jp_x = new JScrollPane(textArea_x);
		panel_17.add(jp_x, BorderLayout.CENTER);
		textArea_x.setLineWrap(true);       // Bật tự động xuống dòng
		textArea_x.setWrapStyleWord(true);  // Đảm bảo xuống dòng tại các từ
		
		JPanel panel_8 = new JPanel();
		panel_3.add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_18 = new JPanel();
		panel_8.add(panel_18, BorderLayout.NORTH);
		
		JLabel lblNewLabel_4 = new JLabel("Khóa công khai y");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_18.add(lblNewLabel_4);
		
		JPanel panel_19 = new JPanel();
		panel_8.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new BorderLayout());
		textArea_y = new JTextArea();
		JScrollPane jp_y = new JScrollPane(textArea_y);
		panel_19.add(jp_y, BorderLayout.CENTER);
		textArea_y.setLineWrap(true);       // Bật tự động xuống dòng
		textArea_y.setWrapStyleWord(true);  // Đảm bảo xuống dòng tại các từ
		
		JPanel panel_9 = new JPanel();
		panel_3.add(panel_9);
		panel_9.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_20 = new JPanel();
		panel_9.add(panel_20, BorderLayout.NORTH);
		
		JLabel lblNewLabel_5 = new JLabel("Nhập k");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_20.add(lblNewLabel_5);
		
		JPanel panel_21 = new JPanel();
		panel_9.add(panel_21, BorderLayout.CENTER);
		panel_21.setLayout(new BorderLayout());
		textArea_k= new JTextArea();
		//thiết lập có thể chính sửa
				textArea_k.setEditable(true);
		JScrollPane jp_k = new JScrollPane(textArea_k);
		panel_21.add(jp_k,BorderLayout.CENTER);
		textArea_k.setLineWrap(true);       // Bật tự động xuống dòng
		textArea_k.setWrapStyleWord(true);  // Đảm bảo xuống dòng tại các từ
		
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(1, 2, 10, 10));
		
		JPanel panel_22 = new JPanel();
		panel_1.add(panel_22);
		panel_22.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_6 = new JLabel("                Phát sinh chữ ký");
		lblNewLabel_6.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_22.add(lblNewLabel_6, BorderLayout.NORTH);
		
		JPanel panel_24 = new JPanel();
		panel_22.add(panel_24, BorderLayout.CENTER);
		panel_24.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_26 = new JPanel();
		panel_24.add(panel_26);
		panel_26.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_8 = new JLabel("Nhập văn bản");
		lblNewLabel_8.setForeground(Color.BLUE);
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_26.add(lblNewLabel_8, BorderLayout.WEST);
		
		JPanel panel_29 = new JPanel();
		panel_26.add(panel_29, BorderLayout.CENTER);
		panel_29.setLayout(new BorderLayout());
//		JTextArea van_ban = new JTextArea();
//		van_ban.setText("Nhập văn bản cần ký !");
//		JScrollPane jp_vanban = new JScrollPane(van_ban);
//		panel_29.add(jp_vanban);
		vanban_sinh = new JTextPane();
		vanban_sinh.setEditable(true);
		vanban_sinh.setText("Nhập văn bản cần ký !");
        JScrollPane jp_vanban_sinh = new JScrollPane(vanban_sinh);
        panel_29.add(jp_vanban_sinh, BorderLayout.CENTER);

	
		
		JPanel panel_27 = new JPanel();
		panel_24.add(panel_27);
		panel_27.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_31 = new JPanel();
		panel_27.add(panel_31);
		panel_31.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_36 = new JPanel();
		panel_31.add(panel_36);
		panel_36.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_38 = new JPanel();
		panel_36.add(panel_38);
		
		JPanel panel_39 = new JPanel();
		panel_36.add(panel_39);
		panel_39.setLayout(new GridLayout(1, 2, 0, 0));
		
		thuc_hien_ky = new JButton("Thực hiện ký");
		thuc_hien_ky.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_39.add(thuc_hien_ky);
		
		file_vanbansinh = new JButton("File");
		file_vanbansinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_39.add(file_vanbansinh);
		
		JPanel panel_37 = new JPanel();
		panel_31.add(panel_37);
		
		JPanel panel_32 = new JPanel();
		panel_27.add(panel_32);
		panel_32.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_10 = new JLabel("Băm MD5");
		lblNewLabel_10.setForeground(Color.RED);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_32.add(lblNewLabel_10, BorderLayout.WEST);
		
		JPanel panel_35 = new JPanel();
		panel_32.add(panel_35, BorderLayout.CENTER);
		panel_35.setLayout(new BorderLayout());
		mabam_lan1 = new JTextField();
		panel_35.add(mabam_lan1);
		
		JPanel panel_30 = new JPanel();
		panel_27.add(panel_30);
		panel_30.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_9 = new JLabel("                               Chữ ký  (r,s) = ");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 23));
		panel_30.add(lblNewLabel_9, BorderLayout.SOUTH);
		
		JPanel panel_28 = new JPanel();
		panel_24.add(panel_28);
		panel_28.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_33 = new JPanel();
		panel_28.add(panel_33, BorderLayout.EAST);
		panel_33.setLayout(new GridLayout(2, 1, 0, 0));
		
		chuyen = new JButton("Chuyển");
		chuyen.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_33.add(chuyen);
		
		 luu = new JButton("Lưu");
		luu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_33.add(luu);
		
		JPanel panel_34 = new JPanel();
		panel_28.add(panel_34, BorderLayout.CENTER);
		panel_34.setLayout(new BorderLayout());
		chuky_sinh = new JTextPane();
		//thiết lập có thể chỉnh sửa
		chuky_sinh.setEditable(true);
		chuky_sinh.setFont(new Font("Tahoma", Font.PLAIN, 25));
        JScrollPane jp_chuky_sinh = new JScrollPane(chuky_sinh);
        panel_34.add(jp_chuky_sinh, BorderLayout.CENTER);
        chuky_sinh.setAutoscrolls(true);       // Bật tự động xuống dòng
//        chuky_sinh.setWrapStyleWord(true);  // Đảm bảo xuống dòng tại các từ
		

		
		JPanel panel_23 = new JPanel();
		panel_1.add(panel_23);
		panel_23.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_7 = new JLabel("                 Kiểm tra chữ ký");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		panel_23.add(lblNewLabel_7, BorderLayout.NORTH);
		
		JPanel panel_25 = new JPanel();
		panel_23.add(panel_25, BorderLayout.CENTER);
		panel_25.setLayout(new GridLayout(3, 1, 0, 0));
		
		JPanel panel_41 = new JPanel();
		panel_25.add(panel_41);
		panel_41.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_11 = new JLabel("Văn bản ký");
		lblNewLabel_11.setForeground(Color.RED);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_41.add(lblNewLabel_11, BorderLayout.WEST);
		
		JPanel panel_43 = new JPanel();
		panel_41.add(panel_43, BorderLayout.CENTER);
		panel_43.setLayout(new BorderLayout());		
		vanbanky = new JTextPane();
            

		vanbanky.setText("văn bản ký !");
        JScrollPane jp_vanbanky = new JScrollPane(vanbanky);
        panel_43.add(jp_vanbanky, BorderLayout.CENTER);
		
		JPanel panel_42 = new JPanel();
		panel_25.add(panel_42);
		panel_42.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_44 = new JPanel();
		panel_42.add(panel_44, BorderLayout.NORTH);
		panel_44.setLayout(new BorderLayout(0, 0));
		
		file_vanbanky = new JButton("File văn bản");
		file_vanbanky.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_44.add(file_vanbanky, BorderLayout.EAST);
		
		JPanel panel_45 = new JPanel();
		panel_42.add(panel_45, BorderLayout.CENTER);
		panel_45.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_12 = new JLabel("Chữ ký");
		lblNewLabel_12.setForeground(Color.BLACK);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_45.add(lblNewLabel_12, BorderLayout.WEST);
		
		JPanel panel_46 = new JPanel();
		panel_45.add(panel_46, BorderLayout.CENTER);
		panel_46.setLayout(new BorderLayout());
		chuky = new JTextPane();
		chuky.setFont(new Font("Tahoma", Font.PLAIN, 25));
        JScrollPane jp_chuky = new JScrollPane(chuky);
        panel_46.add(jp_chuky, BorderLayout.CENTER);
		
		JPanel panel_40 = new JPanel();
		panel_25.add(panel_40);
		panel_40.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_47 = new JPanel();
		panel_40.add(panel_47, BorderLayout.NORTH);
		panel_47.setLayout(new GridLayout(1, 2, 100,100));
		
		kiemtrachuky = new JButton("Kiểm tra");
		kiemtrachuky.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_47.add(kiemtrachuky);
		
		file_chuky = new JButton("File chữ ký");
		file_chuky.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_47.add(file_chuky);
		
		JPanel panel_48 = new JPanel();
		panel_40.add(panel_48, BorderLayout.CENTER);
		panel_48.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_49 = new JPanel();
		panel_48.add(panel_49, BorderLayout.WEST);
		panel_49.setLayout(new GridLayout(2, 1, 0, 50));
		
		JLabel lblNewLabel_13 = new JLabel("Băm MD5");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_49.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Thông báo");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_49.add(lblNewLabel_14);
		
		JPanel panel_50 = new JPanel();
		panel_48.add(panel_50, BorderLayout.CENTER);
		panel_50.setLayout(new GridLayout(3, 1, 20, 20));
		
		mabam_lan2 = new JTextField();
		panel_50.add(mabam_lan2);
		mabam_lan2.setColumns(10);
		
		thong_bao_1 = new JLabel("");
		thong_bao_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_50.add(thong_bao_1);
		
		thong_bao_2 = new JLabel("");
		thong_bao_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_50.add(thong_bao_2);
		
		
		
		//tạo ra đối tượng lắng nghe hành động
		controller v = new controller(this);
		this.button_sinhkhoa.addActionListener(v);
		this.file_vanbansinh.addActionListener(v);
		this.file_vanbanky.addActionListener(v);
		this.file_chuky.addActionListener(v);
		this.thuc_hien_ky.addActionListener(v);
		this.chuyen.addActionListener(v);
		this.luu.addActionListener(v);
		this.kiemtrachuky.addActionListener(v);
	
	}
	public JTextPane getChuky_sinh() {
		return chuky_sinh;
	}


	public void setChuky_sinh(JTextPane chuky_sinh) {
		this.chuky_sinh = chuky_sinh;
	}


	public JLabel getThong_bao_1() {
		return thong_bao_1;
	}


	public void setThong_bao_1(JLabel thong_bao_1) {
		this.thong_bao_1 = thong_bao_1;
	}


	public JLabel getThong_bao_2() {
		return thong_bao_2;
	}


	public void setThong_bao_2(JLabel thong_bao_2) {
		this.thong_bao_2 = thong_bao_2;
	}


	public JTextField getMabam_lan1() {
		return mabam_lan1;
	}


	public void setMabam_lan1(JTextField mabam_lan1) {
		this.mabam_lan1 = mabam_lan1;
	}


	public JTextPane getVanbanky() {
		return vanbanky;
	}


	public void setVanbanky(JTextPane vanbanky) {
		this.vanbanky = vanbanky;
	}


	public JTextPane getChuky() {
		return chuky;
	}


	public void setChuky(JTextPane chuky) {
		this.chuky = chuky;
	}
// View Controller
//  model

	public void sinhkhoa() {
	    modelview.sinhkhoa();
    	this.textArea_q.setText(this.modelview.convert(this.modelview.getQ()));
    	this.textArea_p.setText(this.modelview.convert(this.modelview.getP()));
    	this.textArea_h.setText(this.modelview.convert(this.modelview.getH()));
    	this.textArea_x.setText(this.modelview.convert(this.modelview.getX()));
    	this.textArea_y.setText(this.modelview.convert(this.modelview.getY()));
    	this.textArea_k.setText(this.modelview.convert(this.modelview.getK()));
	}
	public void chukysinh() {
		modelview.thuchienky(textArea_q, textArea_p, textArea_k, textArea_h, textArea_x, vanban_sinh);
		this.mabam_lan1.setText(this.modelview.getBamMD5());
		this.chuky_sinh.setText(this.modelview.getChuky());
		this.thong_bao_1.setText(this.modelview.getThongbaoloi_1());
		this.textArea_y.setText(this.modelview.convert(this.modelview.getY()));
	}
	public void  chuyen() {
		this.chuky.setText(this.chuky_sinh.getText());
		StyledDocument sourceDoc = vanban_sinh.getStyledDocument();
        StyledDocument targetDoc = vanbanky.getStyledDocument();
//        //lấy định dạng căn chỉnh lề
//        try {
//			targetDoc.insertString(targetDoc.getLength(), sourceDoc.getText(0, sourceDoc.getLength()), null);
//			AttributeSet attrs = sourceDoc.getParagraphElement(0).getAttributes();
//			targetDoc.setParagraphAttributes(0, targetDoc.getLength(), attrs, false);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
        try {
        	
            /*
             * Ý nghĩa: Xóa tất cả nội dung hiện có trong targetDoc (tài liệu đích).
               targetDoc.getLength(): Lấy độ dài hiện tại của tài liệu, từ đó biết cần xóa bao nhiêu ký tự.
               targetDoc.remove(0, targetDoc.getLength());: Xóa từ vị trí 0 đến hết chiều dài của tài liệu.
             */
        	// Xóa nội dung cũ trong vanbanky
			targetDoc.remove(0, targetDoc.getLength());
			 targetDoc.insertString(0, sourceDoc.getText(0, sourceDoc.getLength()), sourceDoc.getCharacterElement(0).getAttributes());
             for (int i = 0; i < sourceDoc.getLength(); i++) {
                 Element element = sourceDoc.getCharacterElement(i);
                 targetDoc.setCharacterAttributes(i, element.getEndOffset() - element.getStartOffset(), element.getAttributes(), true);
             }
		} catch (BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        

	}
	public void luufile() {
		this.modelview.luufile(chuky_sinh);
	}
	public void kiemtra() {
		this.modelview.kiemtra(textArea_q, textArea_p, textArea_h, textArea_y, vanbanky, chuky);
		this.thong_bao_1.setText(this.modelview.getThongbaoloi_1());
		this.mabam_lan2.setText(this.modelview.getBamMD5_2());
		this.thong_bao_2.setText(this.modelview.getThongbaoloi_2());
	}
}
