package DAO;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import DTO.DanhMucDTO;
import GUI.PNBanHangGUI;
import GUI.PNHoadonGUI;
import GUI.PNNhanvienGUI;
import GUI.PNPhieunhapGUI;
import GUI.PNQuanLyKhachHangGUI;
import GUI.PNSanphamGUI;
import GUI.PNThongKeGUI;


public class ChuyenmanhinhQLDAO {
	
	private JPanel root;
	private String kindSelected = "";
	private List<DanhMucDTO> listItem = null;
	
	
	public ChuyenmanhinhQLDAO(JPanel jpnlRoot) {
		// TODO Auto-generated constructor stub
		this.root = jpnlRoot;
	}
	
	public void setView(JPanel jpnItem, JLabel jlbItem) {
		kindSelected = "trangchu";
		jpnItem.setBackground(new Color(23, 70, 162));
        jlbItem.setBackground(new Color(23, 70, 162));
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new PNBanHangGUI());
        root.validate();
        root.repaint();
	}
	  public void setEvent(List<DanhMucDTO> listItem) {
	        this.listItem = listItem;
	        for (DanhMucDTO item : listItem) {
	            item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
	        }
	    }

	    class LabelEvent implements MouseListener {

	        private JPanel node;
	        private String kind;
	        private JPanel jpnItem;
	        private JLabel jlbItem;

	        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
	            this.kind = kind;
	            this.jpnItem = jpnItem;
	            this.jlbItem = jlbItem;
	        }
	        @Override 
	        public void mouseClicked(MouseEvent e) {
	            switch (kind) {
	                case "banhang":
	                    node = new PNBanHangGUI();
	                    break;
	                case "phieunhap":
	                    node = new PNPhieunhapGUI();
	                    break;
	                case "sanpham":
	                    node = new PNSanphamGUI();
	                    break;
	                case "nhanvien":
			
					try {
						node = new PNNhanvienGUI();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
	                    break;
	                case "khachhang":
		            	try {
							node = new PNQuanLyKhachHangGUI();
						} catch (Exception e2) {
							// TODO: handle exception
						}
	                case "qlhoadon":
		            	try {
							node = new PNHoadonGUI();
						} catch (Exception e2) {
							// TODO: handle exception
						}
		            	break;
	                case "thongke":
		            	try {
							node = new PNThongKeGUI();
						} catch (Exception e2) {
							// TODO: handle exception
						}
	                default:
	                   // node = new PN_Trangchu();
	            }
	            root.removeAll();
	            root.setLayout(new BorderLayout());
	            root.add(node);
	            root.validate();
	            root.repaint();
	            changeBackGroundColor(kind);
	        }

	        @Override
	        public void mousePressed(MouseEvent e) {
	            kindSelected = kind;
	            jpnItem.setBackground(new Color(23, 70, 162));
	            jlbItem.setBackground(new Color(23, 70, 162));
	        }

	        @Override
	        public void mouseReleased(MouseEvent e) {
	        }

	        @Override
	        public void mouseEntered(MouseEvent e) {
	            jpnItem.setBackground(new Color(23, 70, 162));
	            jlbItem.setBackground(Color.white);
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            if (!kindSelected.equalsIgnoreCase(kind)) {
	                jpnItem.setBackground(Color.white);
	                jlbItem.setBackground(new Color(95, 157, 247));
	            }
	        }

	    }

	    //---Dùng cho giao diện Nhân viên
	    public void setEventNV(List<DanhMucDTO> listItem) {
	        this.listItem = listItem;
	        for (DanhMucDTO item : listItem) {
	            item.getJlb().addMouseListener(new LabelEventNV(item.getKind(), item.getJpn(), item.getJlb()));
	        }
	    }

	    class LabelEventNV implements MouseListener {

	        private JPanel node;
	        private String kind;
	        private JPanel jpnItem;
	        private JLabel jlbItem;

	        public LabelEventNV(String kind, JPanel jpnItem, JLabel jlbItem) {
	            this.kind = kind;
	            this.jpnItem = jpnItem;
	            this.jlbItem = jlbItem;
	        }

	        @Override
	        public void mouseClicked(MouseEvent e) {
	            switch (kind) {
	            case "banhang":
                    node = new PNBanHangGUI();
                    break;
                case "phieunhap":
                    node = new PNPhieunhapGUI();
                    break;
	            case "sanpham":
	                node = new PNSanphamGUI();
	                break;
	            case "nhanvien":
					try {
						node = new PNNhanvienGUI();
						break;
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	            case "khachhang":
	            	try {
						node = new PNQuanLyKhachHangGUI();
					} catch (Exception e2) {
						// TODO: handle exception
					}
	            	break;
	            case "qlhoadon":
	            	try {
						node = new PNHoadonGUI();
					} catch (Exception e2) {
						// TODO: handle exception
					}
	            	break;
	            case "thongke":
	            	try {
						node = new PNThongKeGUI();
					} catch (Exception e2) {
						// TODO: handle exception
					}
	            default:
	               // node = new PN_Trangchu();
	            }
	            root.removeAll();
	            root.setLayout(new BorderLayout());
	            root.add(node);
	            root.validate();
	            root.repaint();
	            changeBackGroundColor(kind);
	        }

	        @Override
	        public void mousePressed(MouseEvent e) {
	            kindSelected = kind;
	            jpnItem.setBackground(new Color(23, 70, 162));
	            jlbItem.setBackground(new Color(23, 70, 162));
	        }

	        @Override
	        public void mouseReleased(MouseEvent e) {
	        }

	        @Override
	        public void mouseEntered(MouseEvent e) {
	            jpnItem.setBackground(new Color(23, 70, 162));
	            jlbItem.setBackground(new Color(23, 70, 162));
	        }

	        @Override
	        public void mouseExited(MouseEvent e) {
	            if (!kindSelected.equalsIgnoreCase(kind)) {
	                jpnItem.setBackground(Color.white);
	                jlbItem.setBackground(new Color(95, 157, 247));
	            }
	        }

	    }
	    
	    
	    private void changeBackGroundColor(String kind) {
	        for (DanhMucDTO item : listItem) {
	            if (item.getKind().equalsIgnoreCase(kind)) {
	            	item.getJpn().setBackground(new Color(23, 70, 162));
	                item.getJlb().setBackground(new Color(23, 70, 162));
	            } else {
	                item.getJlb().setBackground(new Color(95, 157, 247));
	                item.getJpn().setBackground(Color.white);
	            }
	        }
	    }
}
