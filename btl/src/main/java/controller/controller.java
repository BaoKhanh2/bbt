package controller;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.view;

public class controller implements ActionListener{
    private view viewcontroller;
    public controller(view viewcontroller) {
		// TODO Auto-generated constructor stub
    	this.viewcontroller = viewcontroller;
	}
    
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String action = e.getActionCommand();
		if(action.equals("SinhKhoa")) {
			this.viewcontroller.sinhkhoa();
		}else if(action.equals("File")) {
			this.viewcontroller.getModelview().mofile(this.viewcontroller.getVanban_sinh());
		}else if(action.equals("File văn bản")) {
			this.viewcontroller.getModelview().mofile(this.viewcontroller.getVanbanky());
		}else if(action.equals("File chữ ký")) {
			this.viewcontroller.getModelview().mofile(this.viewcontroller.getChuky());
		}else if (action.equals("Thực hiện ký")) {
			this.viewcontroller.chukysinh();
		}else if(action.equals("Chuyển")) {
			this.viewcontroller.chuyen();
		}else if(action.equals("Lưu")) {
			this.viewcontroller.luufile();
		}else if(action.equals("Kiểm tra")) {
			this.viewcontroller.kiemtra();
		}else {
			
		}
	}
	
	
}
