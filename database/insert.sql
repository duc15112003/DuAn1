
use qlcuahanggiaydb;

INSERT INTO tblkhachhang VALUES
('KH1 ', N'Phạm Nhật', N'Anh ', N'Nam ', N'Gò Vấp', N'nguyenanh@gmail.com ', N'vip', 58939.3),
('KH2 ', N'Võ Đức ', N'Chung ', N'Nam ', N'Quận 1', N'chungtang@gmail.com ', N'đặc biệt', 0),
('KH3 ', N'Võ Văn Gia ', N'Bảo', N'Nam ', N'quận 2', N'baovo@gmail.com ', N'vip', 98495),
('KH4 ', N'Phạm Nhật', N'Kim ', N'Nữ ', N'quận 3', N'khoeghe@gmail.com ', N'bình thường', 53576),
('KH5 ', N'Trần Lê Anh ', N'Đào ', N'Nữ ', N'quận 4', N'daotran@gmail.com ', N'bình thường', 1150),
('KH6 ', N'Phạm Hải', N'An ', N'Nam ', N'quận 5', N'abc@gmail.com ', N'bình thường', 6740);

INSERT INTO   tblhoadon   (  MaHD  ,   MaNV  ,   MaKH  ,   MaKM  ,   NgayBan  ,   TongTien  ) VALUES
('HD001 ', N'admin ', N'KH1 ', N'KM2 ', N'08 Jun 2020', 572),
('HD002 ', N'admin ', N'KH2 ', N'KM6 ', N'08 Jun 2020', 899),
('HD003 ', N'admin ', N'KH5 ', N'KM4 ', N'08 Jun 2020', 899),
('HD004 ', N'admin ', N'KH6 ', N'KM3 ', N'08 Jun 2020', 1448),
('HD005 ', N'admin ', N'KH3 ', N'KM3 ', N'08 Jun 2020', 1890),
('HD006 ', N'admin ', N'KH1 ', N'KM2 ', N'08 Jun 2020', 899),
('HD007 ', N'admin ', N'KH2 ', N'KM6 ', N'08 Jun 2020', 7690),
('HD008 ', N'admin ', N'KH1 ', N'KM6 ', N'08 Jun 2020', 2727),
('HD010 ', N'admin ', N'KH6 ', N'KM6 ', N'13 Jun 2020', 572),
('HD011 ', N'admin ', N'KH6 ', N'KM6 ', N'13 Jun 2020', 909),
('HD012 ', N'admin ', N'KH4 ', N'KM6 ', N'14 Jun 2020', 631);

INSERT INTO tblchitiethd (Magiay, MaHD, SoLuong, GiaBan) VALUES
('SP1 ', N'HD001', 1, 572),
('SP1 ', N'HD004', 1, 572),
('SP1 ', N'HD007', 8, 4576),
('SP1 ', N'HD010', 1, 572),
('SP1 ', N'HD012', 1, 572),
('SP2 ', N'HD003', 1, 631),
('SP2 ', N'HD004', 1, 631),
('SP2 ', N'HD007', 8, 5048),
('SP2 ', N'HD012', 1, 631),
('SP3 ', N'HD001', 1, 724),
('SP3 ', N'HD003', 1, 724),
('SP3 ', N'HD004', 2, 1448),
('SP3 ', N'HD007', 6, 5792),
('SP4 ', N'HD002', 1, 899),
('SP4 ', N'HD003', 1, 899),
('SP4 ', N'HD004', 2, 1798),
('SP4 ', N'HD006', 1, 899),
('SP4 ', N'HD007', 5, 4495),
('SP5 ', N'HD002', 1, 909),
('SP5 ', N'HD006', 3, 2727),
('SP5 ', N'HD007', 6, 5454),
('SP5 ', N'HD008', 3, 2727),
('SP5 ', N'HD011', 1, 909),
('SP6 ', N'HD005', 2, 1890),
('SP6 ', N'HD007', 8, 7560);

INSERT INTO   tblchitietkm   (  MaGiay  ,   MaKM  ,   TiLeKM  ) VALUES
('SP1 ', N'KM1', 0.1),
('SP1 ', N'KM5', 0.5),
('SP1 ', N'KM6', 0.5),
('SP2 ', N'KM1', 0.1),
('SP2 ', N'KM2', 0.2),
('SP2 ', N'KM5', 0.5),
('SP2 ', N'KM6', 0.5),
('SP3 ', N'KM1', 0.1),
('SP3 ', N'KM4', 0.4),
('SP3 ', N'KM5', 0.5),
('SP3 ', N'KM6', 0.3),
('SP4 ', N'KM3', 0.3),
('SP4 ', N'KM5', 0.5),
('SP5 ', N'KM4', 0.4),
('SP5 ', N'KM5', 0.5);

INSERT INTO   tblchitietpn   (  MaGiay  ,   MaPN  ,   SoLuong  ,   GiaNhap  ) VALUES
('SP1 ', N'PN001', 10, 472),
('SP2 ', N'PN001', 10, 563),
('SP3 ', N'PN001', 10, 624),
('SP4 ', N'PN001', 10, 799),
('SP5 ', N'PN001', 10, 809),
('SP6 ', N'PN001', 10, 845),
('SP7 ', N'PN001', 10, 1250),
('SP8 ', N'PN001', 10, 1550),
('SP9 ', N'PN001', 10, 2131),
('SP10 ', N'PN001', 10, 2131),
('SP11 ', N'PN001', 10, 2250),
('SP12 ', N'PN001', 10, 2470),
('SP13 ', N'PN001', 10, 2490),
('SP14 ', N'PN001', 10, 2500),
('SP15 ', N'PN001', 10, 2590),
('SP16 ', N'PN001', 10, 2699),
('SP17 ', N'PN001', 10, 2850),
('SP18 ', N'PN001', 10, 2880),
('SP19 ', N'PN001', 10, 3319),
('SP20 ', N'PN001', 10, 8898);


INSERT INTO   tblkhuyenmai   (  MaKM  ,   TenChuongTrinh  ,   LoaiChuongTrinh  ,   DieuKien  ,   NgayBatDau  ,   NgayKetThuc  ) VALUES
('KM1 ', N'Mùa hè xanh ', N'Loại 1 ', N'vip ', N'13 May 2020 ', N'15 May 2020'),
('KM2 ', N'Ngày vàng ', N'Loại 3 ', N'đặc biệt ', N'01 Jun 2020 ', N'08 Jun 2020'),
('KM3 ', N'Ngày trở về ', N'Loại 2 ', N'vip ', N'08 Jun 2020 ', N'17 Jun 2020'),
('KM4 ', N'Mùa đông lạnh giá ', N'Loại 3 ', N'bình thường ', N'01 Jun 2020 ', N'17 Jun 2020'),
('KM5 ', N'Ngày mới ', N'Loại 3 ', N'bình thường ', N'01 Jan 2020 ', N'01 Jan 2030'),
('KM6 ', N'admin ', N'Loại 1 ', N'bình thường ', N'1 Jun 2020 ', N'30 Jun 2020');

INSERT INTO   tblloai   (  Maloai  ,   Tenloai  ) VALUES
('1 ', N'sneaker'),
('2 ', N'Running'),
('3 ', N'Fashion'), 
('4 ', N'Basketball'),
('5 ', N'Soccer'); 

INSERT INTO   tblmausac   (  Mamau  ,   Tenmau  ) VALUES
('BLK ', N'Black'),
('BLU ', N'Blue'),
('GR ', N'Green'),
('ORG ', N'Orange'),
('WT ', N'White');

INSERT INTO   tblnhacungcap   (  MaNCC  ,   TenNCC  ,   DiaChi  ,   Email  ) VALUES
('NCC1 ', N'TNHH An Giang Samho', N'Lô C3 và lô C5, Khu công nghiệp Bình Hòa, Xã Bình Hòa, Huyện Châu Thành, Tỉnh An Giang, Việt Nam', N'sambo123@gmail.com'),
('NCC2 ', N'CHANG SHIN VIETNAM COMPANY LTD', N'Khu Công nghiệp Thạnh Phú, Xã Thạnh Phú, Huyện Vĩnh Cửu, Tỉnh Đồng Nai, Việt Nam ', N'changshin123@gmail.com'),
('NCC3 ', N'CÔNG TY TNHH Bitis ', N' 22 Lý Chiêu Hoàng, Phường 10, Quận 6, TP. Hồ Chí Minh ', N'chamsockhachhang@bitis.com.vn');


INSERT INTO   tblnhanvien   (  MaNV  ,   Ho  ,   Ten  ,   GioiTinh  ,   DiaChi  ,   DienThoai  ,   Email  ,   Luong  ,   ChucVu  ,   Anh  ) VALUES
('admin ', N'Quản trị ', N'Viên ', N'Nam ', N'2 Quang Trung,Phường 8,Quận Gò vấp, TPHCM', 1001011101, 'admin@admin.vn', 999999, 'Quản trị viên ', N'boy 4'),
('id1 ', N'Nguyễn Thị ', N'Thư ', N'Nữ ', N'123 Lũy Bán Bích,P.Tân Thới Hòa, Q.Tân Phú,TPHCM', 1234567890, 'nguyenvanan@gamil.co', 1000, 'Thư ký ', N'girl 1'),
('id2 ', N'Tàu Văn ', N'Phà ', N'Nam ', N'23 Phạm Văn Đồng,Phường 3, Q.Gò Vấp,TPHCM', 1239876540, 'taunhobien@gamil.com', 800, 'Kiểm tra hàng hóa ', N'boy 2'),
('id3 ', N'Trần ', N'Dần ', N'Nam ', N'3 Cộng Hòa ,Phường 4,Q.Tân Bình,TpHCM', 2147483647, 'trandan@gmail.com', 300, 'Nhập Hàng ', N'boy 3'),
('id4 ', N'Lê Văn ', N'Hoàng ', N'Nữ ', N'23 Thống Nhất,Phường 10,Q.Gò Vấp,TpHCM', 41234111, 'levanhoang@gmail.com', 8000, 'Khuyến Mãi ', N'girl 3'),
('id5 ', N'Nguyễn Thị Lê ', N'Kim ', N'Nữ ', N'58/6 Lê Văn Việt,P.Hiệp Phú,Quận 9,TpHCM', 123456789, 'nguyenthilekim@gmail', 900, 'Hóa Đơn ', N'girl 2');

INSERT INTO   tblphieunhap   (  MaPN  ,   MaNCC  ,   MaNV  ,   NgayNhap  ,   TongTien  ) VALUES
('PN001' , N'NCC1 ', N'admin ', N'08 Jun 2020', 10500),
('PN002 ', N'NCC2 ', N'admin ', N'08 Jun 2020', 3000),
('PN003 ', N'NCC3 ', N'admin ', N'11 Jun 2020', 2100);
INSERT INTO   tblsanpham   (  Magiay  ,   Tengiay  ,   Soluong  ,   Gia  ,   Size  ,   Doituongsd  ,   Chatlieu  ,   Maloai  ,   Maxx  ,   Mamau  ,   Mathuonghieu  ) VALUES
('SP1 ', N'Biti DSMH03800', 6, 572, 40, N'Nam ', N'Vải ', N'5 ', N'VN ', N'GR ', N'BT'),
('SP2 ', N'Biti DSMH02401DOO', 6, 631, 40, N'Nam ', N'Vải ', N'5 ', N'VN ', N'ORG ', N'BT'),
('SP3 ', N'Biti DSMH11100DOO', 6, 724, 40, N'Nam ', N'Vải ', N'5 ', N'VN ', N'ORG ', N'BT'),
('SP4 ', N'Giày sneaker af1', 10, 899, 39, N'Nam ', N'Vải ', N'3 ', N'US ', N'WT ', N'NK'),
('SP5 ', N'Biti DSMH10000', 6, 909, 40, N'Nam ', N'Vải ', N'2 ', N'VN ', N'BLK ', N'BT'),
('SP6 ', N'Biti DSMH08300', 6, 945, 40, N'Tất cả ', N'Vải ', N'2 ', N'VN ', N'BLK ', N'BT'),
('SP7 ', N'EQ21 RUN COLD.RDY', 3,1350, 40, N'Nam ', N'Vải', N'2 ', N'US ', N'BLK ', N'AD'),
('SP8 ', N'JapanSport HP5982', 3,1650, 40, N'Nam ', N'Vải', N'1 ', N'US ', N'BLK ', N'AD'),
('SP9 ', N'Nike Air Max 90', 10, 2231, 40, N'Nam ', N'Vải ', N'3 ', N'US ', N'WT ', N'NK'),
('SP10 ', N'Air Zoom Structure ', 10, 2231, 30, N'Nữ ', N'Vải ', N'2 ', N'US ', N'WT ', N'NK'),
('SP11 ', N'Dame 7 Acid Mint', 10, 2350, 40, N'Nam ', N'Vải ', N'4 ', N'US ', N'GR ', N'AD'),
('SP12 ', N'Nike Air Max Systm', 10, 2570, 30, N'Nữ', N'Vải', N'3 ', N'US ', N'WT ', N'NK'),
('SP13 ', N'Ric Flair Royal ', 10, 2590, 40, N'Nam ', N'Vải ', N'4 ', N'US ', N'BLU ', N'AD'),
('SP14 ', N'JapanSport GY0383', 3,2600, 40, N'Nam ', N'Vải', N'4 ', N'US', N'BLK', N'AD'),
('SP15 ', N'Vol.6 Impact Taxi', 6, 2690, 40, N'Nam ', N'Vải ', N'4 ', N'US ', N'ORG ', N'AD'),
('SP16 ', N'Nike Air Max Excee', 3, 2799, 33, N'Nữ ', N'Vải ', N'3 ', N'US ', N'WT ', N'NK'),
('SP17 ', N'10 PRO TF SHADOW', 3, 2950, 40, N'Nam ', N'Vải ', N'5 ', N'US ', N'BLK ', N'NK'),
('SP18 ', N'JapanSport GX9247', 6, 2980, 40, N'Nam ', N'Vải ', N'3 ', N'US ', N'WT ', N'AD'),
('SP19 ', N'Air Winflo 10 Prm', 6, 3419, 30, N'Nữ ', N'Vải ', N'2 ', N'US ', N'WT ', N'NK'),
('SP20 ', N'PREDATOR ACCURACY.1', 6, 8998, 40, N'Nam ', N'Vải ', N'5 ', N'US ', N'WT ', N'AD');




INSERT INTO tblthuonghieu (Mathuonghieu, Tenthuonghieu, Diachi, Email) VALUES
('AD', N'Adidas', N'USA', N'adidas@gmail.com'),
('BT', N'Bitis', N'VietNam', N'bitis@gmial.com'),
('NK', N'Nike', N'USA', N'nike@gmail.com');

INSERT INTO tblxuatxu (Maxx, Tennuoc) VALUES
('CN', N'China'),
('ID', N'Indonesia'),
('UK', N'United Kingdom'),
('US', N'USA'),
('VN', N'VietNam');

INSERT INTO  tbltaikhoan  ( tendangnhap ,  matkhau ,  capbac ) VALUES
('admin', 'admin', 'QL'),
('id1', '123', 'NV');
