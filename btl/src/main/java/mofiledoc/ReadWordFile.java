package mofiledoc;

import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTRPr;

import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTVerticalAlignRun;

public class ReadWordFile {
    public static void main(String[] args) {
        try {
            // Thiết lập Look and Feel cho JFileChooser để phù hợp với hệ thống
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Hiển thị hộp thoại chọn tệp
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        // Kiểm tra xem người dùng có chọn một tệp hay không
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            String filePath = file.getPath();

            // Tạo cửa sổ Swing
            JFrame frame = new JFrame("Word Document Viewer");
            JTextPane textPane = new JTextPane();
            textPane.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(textPane);
            frame.getContentPane().add(scrollPane);
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            try (FileInputStream fis = new FileInputStream(filePath);
                 XWPFDocument document = new XWPFDocument(fis)) 
            {

                // Lấy danh sách các đoạn văn trong tài liệu
                List<XWPFParagraph> paragraphs = document.getParagraphs();
                StyledDocument styledDoc = textPane.getStyledDocument();

                // Xử lý từng đoạn văn và thêm vào JTextPane
                for (XWPFParagraph para : paragraphs) {
                    List<XWPFRun> runs = para.getRuns();
                    for (XWPFRun run : runs) {
                        String text = run.getText(0);
                        if (text != null) {
                            MutableAttributeSet attr = new SimpleAttributeSet();
                            StyleConstants.setBold(attr, run.isBold());
                            StyleConstants.setItalic(attr, run.isItalic());
                            if (run.getColor() != null) {
                                StyleConstants.setForeground(attr, Color.decode("#" + run.getColor()));
                            }
                            if (run.getUnderline() != null) {
                                StyleConstants.setUnderline(attr, true);
                            }
//
                            // Kiểm tra và thiết lập số mũ hoặc chỉ số dưới
                            //Trong trường hợp này, nó trả về giá trị của vertAlign, nơi giá trị 1 biểu thị số mũ (superscript)
                            //và giá trị 2 biểu thị chỉ số dưới (subscript).
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
                            styledDoc.insertString(styledDoc.getLength(), text, attr);
                        }
                    }
                    styledDoc.insertString(styledDoc.getLength(), "\n", null);
                }
            } catch (IOException | javax.swing.text.BadLocationException e) {
                e.printStackTrace();
            }
            System.out.println(textPane.getColorModel());
            // Hiển thị cửa sổ
            frame.setVisible(true);
        } else {
            System.out.println("Không có tệp nào được chọn.");
        }
    }
}
