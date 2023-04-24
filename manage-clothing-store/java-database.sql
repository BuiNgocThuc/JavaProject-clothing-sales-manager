CREATE DATABASE QUANLY_BQA
USE QUANLY_BQA

CREATE TABLE [NHACUNGCAP] (
  [MANCC] VARCHAR(10) PRIMARY KEY,
  [TENNCC] NVARCHAR(50),
  [SDTNCC] VARCHAR(10),
  [DIACHINCC] NVARCHAR(100),
  [TRANGTHAI] NVARCHAR(50)
)
GO

CREATE TABLE [NHOMQUYEN] (
  [MAQUYEN] VARCHAR(10) PRIMARY KEY,
  [TENQUYEN] NVARCHAR(50),
  [MOTAQUYEN] NVARCHAR(200),
  [TRANGTHAI] NVARCHAR(50)
)
GO

CREATE TABLE [NHANVIEN] (
  [MANV] VARCHAR(10) PRIMARY KEY,
  [TENNV] NVARCHAR(50),
  [NGAYSINH] DATE,
  [SDTNV] VARCHAR(10),
  [DIACHINV] NVARCHAR(100),
  [TRANGTHAI] NVARCHAR(50)
)
GO

CREATE TABLE [PHIEUNHAP] (
  [MAPN] VARCHAR(10) PRIMARY KEY,
  [PN_MANCC] VARCHAR(10),
  [PN_MANV] VARCHAR(10),
  [NGAYNHAP] DATE,
  [PN_TONGTIEN] FLOAT
)
GO

CREATE TABLE [THUONGHIEU] (
  [MATH] VARCHAR(10) PRIMARY KEY,
  [TENTH] NVARCHAR(50),
  [TRANGTHAI] NVARCHAR(30)
)
GO

CREATE TABLE [SANPHAM] (
  [MASP] VARCHAR(10) PRIMARY KEY,
  [SP_MATH] VARCHAR(10),
  [TENSP] NVARCHAR(50),
  [SIZE] VARCHAR(10),
  [MAUSAC] VARCHAR(10),
  [HINHANH] VARCHAR(255),
  [GIA_NHAP] FLOAT,
  [SP_GIASP] FLOAT,
  [SP_SOLUONGSP] INT,
  [TRANGTHAI] NVARCHAR(10)
)
GO

CREATE TABLE [KICHCO] (
  [MASIZE] VARCHAR(10) PRIMARY KEY,
  [TENSIZE] VARCHAR(5)
)
GO

CREATE TABLE [MAUSAC] (
  [MAMAU] VARCHAR(10) PRIMARY KEY,
  [TENMAU] NVARCHAR(20)
)
GO

CREATE TABLE [KHUYENMAI] (
  [MAKM] VARCHAR(10) PRIMARY KEY,
  [TENKM] NVARCHAR(50),
  [DIEUKIEN] NVARCHAR(50),
  [GIAMGIA] FLOAT,
  [NGAY_BD] DATE,
  [NGAY_KT] DATE,
  [TRANGTHAI] NVARCHAR(50)
)
GO

CREATE TABLE [CHITIETPHIEUNHAP] (
  [CTPN_MAPN] VARCHAR(10),
  [CTPN_MASP] VARCHAR(10),
  [CTSP_GIASP] FLOAT,
  [CTSP_SOLUONGSP] INT,
  PRIMARY KEY ([CTPN_MASP], [CTPN_MAPN])
)
GO

CREATE TABLE [KHACHHANG] (
  [MAKH] VARCHAR(10) PRIMARY KEY,
  [TENKH] NVARCHAR(50),
  [SDTKH] VARCHAR(10),
  [DIACHIKH] NVARCHAR(100),
  [TRANGTHAI] NVARCHAR(50)
)
GO

CREATE TABLE [HOADON] (
  [MAHD] VARCHAR(10) PRIMARY KEY,
  [HD_MAKH] VARCHAR(10),
  [HD_MAKM] VARCHAR(10),
  [HD_MANV] VARCHAR(10),
  [NGAYNHAP] DATE,
  [HD_TONGTIEN] FLOAT,
  [HD_TINHTRANG] NVARCHAR(50)
)
GO

CREATE TABLE [CHITIETHOADON] (
  [CTHD_MAHD] VARCHAR(10),
  [CTHD_MASP] VARCHAR(10),
  [DONGIA] FLOAT,
  [CTHD_SOLUONG] INT,
  PRIMARY KEY ([CTHD_MAHD], [CTHD_MASP])
)
GO

CREATE TABLE [CHUCNANG] (
  [MACN] NVARCHAR(30) PRIMARY KEY,
  [TENCN] NVARCHAR(30),
  [MOTA] NVARCHAR(200)
)
GO

select * from CHUCNANG

ALTER TABLE CHUCNANG
DROP COLUMN TRANGTHAI

INSERT INTO CHUCNANG(MACN, TENCN, MOTA)
VALUES ('1', 'bán hàng','bán hàng'),
		('2', 'Nhập Hàng', 'Nhập Hàng'), 
('3', 'Sản Phẩm', 'Sản Phẩm'), 
('4', 'Thương Hiệu', 'Thương Hiệu'), 
('5', 'Hóa Đơn', 'Hóa Đơn'), 
('6', 'Phiếu Nhập', 'Phiếu Nhập'), 
('7', 'Nhân Viên', 'Nhân Viên'), 
('8', 'Khách Hàng', 'Khách Hàng'), 
('9', 'Nhà Cung Cấp', 'Nhà Cung Cấp'), 
('10', 'Thống Kê', 'Thống Kê'), 
('11', 'Khuyến Mại', 'Khuyến Mại'), 
('12', 'Tài Khoản', 'Tài Khoản'), 
('13', 'Phân Quyền', 'Phân Quyền');

ALTER TABLE [CHUCNANG]
ADD TRANGTHAI varchar(100);

CREATE TABLE [CHITIETPHANQUYEN] (
  [CTPQ_MAQUYEN] VARCHAR(10),
  [CTPQ_MACN] NVARCHAR(30),
  PRIMARY KEY ([CTPQ_MAQUYEN], [CTPQ_MACN])
)
GO

CREATE TABLE [TAIKHOAN] (
  [Username] varchar(10) PRIMARY KEY,
  [matKhau] varchar(10),
  [MaQuyen] varchar(10),
  [TRANGTHAI] NVARCHAR(30)
)
GO

ALTER TABLE [HOADON] ADD CONSTRAINT [HD_MAKM_FK] FOREIGN KEY ([HD_MAKM]) REFERENCES [KHUYENMAI] ([MAKM])
GO

ALTER TABLE [TAIKHOAN] ADD CONSTRAINT [TK_MaQuyen_FK] FOREIGN KEY ([MaQuyen]) REFERENCES [NHOMQUYEN] ([MAQUYEN])
GO

ALTER TABLE [PHIEUNHAP] ADD CONSTRAINT [PN_MANCC_FK] FOREIGN KEY ([PN_MANCC]) REFERENCES [NHACUNGCAP] ([MANCC])
GO

ALTER TABLE [PHIEUNHAP] ADD CONSTRAINT [PN_MANV_FK] FOREIGN KEY ([PN_MANV]) REFERENCES [NHANVIEN] ([MANV])
GO

ALTER TABLE [SANPHAM] ADD CONSTRAINT [MATH_FK] FOREIGN KEY ([SP_MATH]) REFERENCES [THUONGHIEU] ([MATH])
GO

ALTER TABLE [SANPHAM] ADD CONSTRAINT [MASIZE_FK] FOREIGN KEY ([SIZE]) REFERENCES [KICHCO] ([MASIZE])
GO

ALTER TABLE [SANPHAM] ADD CONSTRAINT [MAMAU_FK] FOREIGN KEY ([MAUSAC]) REFERENCES [MAUSAC] ([MAMAU])
GO

ALTER TABLE [CHITIETPHIEUNHAP] ADD CONSTRAINT [CTPN_MAPN_FK] FOREIGN KEY ([CTPN_MAPN]) REFERENCES [PHIEUNHAP] ([MAPN])
GO

ALTER TABLE [CHITIETPHIEUNHAP] ADD CONSTRAINT [CTPN_MASP_FK] FOREIGN KEY ([CTPN_MASP]) REFERENCES [SANPHAM] ([MASP])
GO

ALTER TABLE [HOADON] ADD CONSTRAINT [HD_MAKH_FK] FOREIGN KEY ([HD_MAKH]) REFERENCES [KHACHHANG] ([MAKH])
GO

ALTER TABLE [HOADON] ADD CONSTRAINT [HD_MANV_FK] FOREIGN KEY ([HD_MANV]) REFERENCES [NHANVIEN] ([MANV])
GO

ALTER TABLE [CHITIETHOADON] ADD CONSTRAINT [CTHD_MAHD_FK] FOREIGN KEY ([CTHD_MAHD]) REFERENCES [HOADON] ([MAHD])
GO

ALTER TABLE [CHITIETHOADON] ADD CONSTRAINT [CTHD_MASP_FK] FOREIGN KEY ([CTHD_MASP]) REFERENCES [SANPHAM] ([MASP])
GO

ALTER TABLE [CHITIETPHANQUYEN] ADD CONSTRAINT [CTPQ_MAQUYEN_FK] FOREIGN KEY ([CTPQ_MAQUYEN]) REFERENCES [NHOMQUYEN] ([MAQUYEN])
GO

ALTER TABLE [CHITIETPHANQUYEN] ADD CONSTRAINT [CTPQ_TENCN_FK] FOREIGN KEY ([CTPQ_MACN]) REFERENCES [CHUCNANG] ([MACN])
GO

ALTER TABLE [TAIKHOAN] ADD CONSTRAINT [Username_FK] FOREIGN KEY ([Username]) REFERENCES [NHANVIEN] ([MANV])
GO

INSERT INTO NHANVIEN (MANV, TENNV, NGAYSINH, SDTNV, DIACHINV, TRANGTHAI)
VALUES
('NV001',N'Nguyễn Quang Hà','2003-12-13','0786773654',N'Quận 8',N'Đang làm việc'),
('NV002',N'Nguyễn Tuấn Anh','2003-10-12','0762057821',N'Quận 7',N'Đang làm việc'),
('NV003',N'Nguyễn Thu Thảo','2003-07-22','0909879012',N'Quận 1',N'Đang làm việc'),
('NV004',N'Trần Minh Tâm','2001-01-04','0707987612',N'Quận 8',N'Đang làm việc'),
('NV005',N'Lê Thị Thu','2002-02-03','0122456789',N'Quận 5',N'Đang làm việc'),
('NV006',N'Đỗ Thị Thùy','2003-12-22','0776123098',N'Thành phố Thủ Đức',N'Đang làm việc'),
('NV007',N'Lê Tấn Kiệt','2002-12-18','0798553121',N'Quận 5',N'Đang làm việc');

INSERT INTO KHACHHANG (MAKH, TENKH, SDTKH, DIACHIKH, TRANGTHAI)
VALUES 
('KH001',N'Ngô Lan Hương','0987456710',N'Quận Tân Bình',N'Khách hàng'),
('KH002',N'Bùi Văn Đức','0720671201',N'Quận 1',N'Khách hàng'),
('KH003',N'Đặng Văn Tiến','0129590123',N'Quận 1',N'Khách hàng'),
('KH004',N'Trần Ngọc Linh','0785555105',N'Quận 5',N'Khách hàng'),
('KH005',N'Nguyễn Văn Tuấn','0933009331',N'Quận 5',N'Khách hàng'),
('KH006',N'Nguyễn Văn Linh','0786765123',N'Quận 8',N'Khách hàng'),
('KH007',N'Văn Mai Linh','0122345075',N'Quận Tân Phú',N'Khách hàng');

INSERT INTO NHACUNGCAP (MANCC, TENNCC, SDTNCC, DIACHINCC, TRANGTHAI)
VALUES 
('NCC001',N'May mặc Trường Nam','0978550644',N'Q. Tân Phú',N'Đang hoạt động'),
('NCC002',N'May mặc Vĩnh Tài','0903373811',N'Quận 3',N'Đang hoạt động'),
('NCC003',N'May Đức Thành','0903643993',N'Long Xuyên, Long An',N'Đang hoạt động'),
('NCC004',N'May mặc Dony','0938842123',N'Huyện Bình Chánh',N'Đang hoạt động'),
('NCC005',N'May mặc Thành Đạt','0961783079',N'Q. Bình Tân',N'Đang hoạt động'),
('NCC006',N'Công ty Thành Công','0835130333',N'Quận 1',N'Đang hoạt động'),
('NCC007',N'Đồng phục Coloury','0986597079',N'Q. Bình Tân',N'Đang hoạt động');

INSERT INTO KHUYENMAI (MAKM, TENKM, DIEUKIEN, GIAMGIA, NGAY_BD, NGAY_KT, TRANGTHAI)
VALUES 
('KM1', N'Giảm giá 20% cho bộ sưu tập áo khoác', 500000, 20, '2023-04-01', '2023-04-30', N'Đang hoạt động'),
('KM2', N'Mua 2 tặng 1 cho bộ sưu tập quần jeans', 1000000, 100, '2023-05-01', '2023-05-15', N'Đang hoạt động'),
('KM3', N'Giảm giá 30% cho bộ sưu tập váy đầm', 300000, 30, '2023-06-01', '2023-06-30', N'Đang hoạt động'),
('KM4', N'Giảm giá 50% cho bộ sưu tập áo phông', 200000, 50, '2023-07-01', '2023-07-31', N'Đang hoạt động'),
('KM5', N'Giảm giá 15% cho bộ sưu tập quần tây', 800000, 15, '2023-08-01', '2023-08-31', N'Đang hoạt động'),
('KM6', N'Mua 3 tặng 1 cho bộ sưu tập quần áo trẻ em', 600000, 25, '2023-09-01', '2023-09-30', N'Đang hoạt động'),
('KM7', N'Giảm giá 25% cho bộ sưu tập áo len', 1500000, 100, '2023-10-01', '2023-10-15', N'Đang hoạt động');

INSERT INTO KICHCO(MASIZE,TENSIZE)
VALUES
('S1','S'),
('S2','M'),
('S3','L'),
('S4','XL'),
('S5','XXL')

INSERT INTO MAUSAC(MAMAU,TENMAU)
VALUES
('M1',N'Trắng'),
('M2', N'Đen'),
('M3', N'Nâu'),
('M4', N'Đỏ'),
('M5', N'Xanh'),
('M6', N'Vàng'),
('M7', N'Cam'),
('M8', N'Tím'),
('M9', N'Hồng')

INSERT INTO SANPHAM(MASP, SP_MATH, TENSP, SIZE, MAUSAC,HINHANH,GIA_NHAP,SP_GIASP,SP_SOLUONGSP,TRANGTHAI)
VALUES
('SP001','TH1',N'Áo','S2','M1','/Icon/icon_img/louisVuitton_product1.jpg',100000,500000,15,N'Còn'),
('SP002','TH1',N'Áo','S3','M1','/Icon/icon_img/louisVuitton_product1.jpg',100000,500000,20,N'Còn'),
('SP003','TH1',N'Áo','S4','M1','/Icon/icon_img/louisVuitton_product1.jpg',100000,500000,10,N'Còn'),
('SP004','TH5',N'Quần','S3','M3','/Icon/icon_img/gucci_product2.jpg',300000,450000,7,N'Còn'),
('SP005','TH5',N'Quần','S2','M3','/Icon/icon_img/gucci_product2.jpg',300000,450000,10,N'Còn'),
('SP006','TH5',N'Quần','S4','M3','/Icon/icon_img/gucci_product2.jpg',300000,450000,5,N'Còn'),
('SP007','TH5',N'Polo','S2','M3','/Icon/icon_img/gucci_product3.jpg',200000,300000,30,N'Còn'),
('SP008','TH5',N'Polo','S1','M3','/Icon/icon_img/gucci_product3.jpg',200000,300000,35,N'Còn'),
('SP009','TH5',N'Polo','S3','M3','/Icon/icon_img/gucci_product3.jpg',200000,300000,30,N'Còn'),
('SP010','TH8','Jacket','S3','M2','/Icon/icon_img/burberry_product4.jpg',400000,800000,5,N'Còn'),
('SP011','TH8','Jacket','S4','M2','/Icon/icon_img/burberry_product4.jpg',400000,800000,5,N'Còn'),
('SP012','TH8',N'Áo','S1','M1','/Icon/icon_img/ao-phong-burberry_product5.jpg',100000,200000,20,N'Còn'),
('SP013','TH8',N'Áo','S2','M1','/Icon/icon_img/ao-phong-burberry_product5.jpg',100000,200000,30,N'Còn'),
('SP014','TH8',N'Áo','S3','M1','/Icon/icon_img/ao-phong-burberry_product5.jpg',100000,200000,20,N'Còn'),
('SP015','TH4',N'Quần','S3','M5','/Icon/icon_img/chanel_product6.jpg',300000,400000,15,N'Còn'),
('SP016','TH4',N'Áo','S2','M2','/Icon/icon_img/chanel_product7.jpg',200000,300000,15,N'Còn'),
('SP017','TH6','Jacket','S3','M6','/Icon/icon_img/versace_product8.jpg',40000,750000,5,N'Còn'),
('SP018','TH7',N'Áo','S2','M2','/Icon/icon_img/dior_product9.jpg',200000,325000,20,N'Còn'),
('SP019','TH7',N'Áo','S1','M2','/Icon/icon_img/dior_product9.jpg',200000,325000,15,N'Còn'),
('SP020','TH7',N'Áo','S3','M2','/Icon/icon_img/dior_product9.jpg',200000,325000,25,N'Còn'),
('SP021','TH7',N'Áo','S4','M2','/Icon/icon_img/dior_product9.jpg',200000,325000,10,N'Còn'),
('SP022','TH3',N'Sơ mi','S2','M5','/Icon/icon_img/prada_product10.jpg',200000,315000,15,N'Còn'),
('SP023','TH3',N'Sơ mi','S3','M5','/Icon/icon_img/prada_product10.jpg',200000,315000,20,N'Còn'),
('SP024','TH3',N'Sơ mi','S4','M5','/Icon/icon_img/prada_product10.jpg',200000,315000,10,N'Còn'),
('SP025','TH2',N'Áo','S2','M6','/Icon/icon_img/hermes_product11.jpg',200000,350000,30,N'Còn')

INSERT INTO NHOMQUYEN (MAQUYEN, TENQUYEN, MOTAQUYEN, TRANGTHAI)
VALUES 
	('Q1', 'QUẢN LÝ', 'TOÀN QUYỀN', 'ĐANG HOẠT ĐỘNG'),
	('Q2', 'NHÂN VIÊN BÁN HÀNG', 'THAO TÁC BÁN HÀNG', 'ĐANG HOẠT ĐỘNG'),
	('Q3', 'NHÂN VIÊN NHẬP HÀNG', 'THAO TÁC NHẬP HÀNG', 'ĐANG HOẠT ĐỘNG'),
	('Q4', 'QUẢN TRỊ', 'TOÀN QUYỀN', 'ĐANG HOẠT ĐỘNG');

select * from TAIKHOAN

INSERT INTO TAIKHOAN (Username, matKhau, MaQuyen, TRANGTHAI)
VALUES
('NV001', 'pass1', 'Q4', 'Đang hoạt động'),
('NV002', 'pass2', 'Q1', 'Đang hoạt động'),
('NV003', 'pass3', 'Q2', 'Đang hoạt động'),
('NV004', 'pass4', 'Q3', 'Đang hoạt động'),
('NV005', 'pass5', 'Q2', 'Đang hoạt động'),
('NV006', 'pass6', 'Q3', 'Đang hoạt động'),
('NV007', 'pass7', 'Q2', 'Đang hoạt động');


INSERT INTO CHITIETPHANQUYEN (CTPQ_MAQUYEN, CTPQ_MACN)
VALUES ('Q1','1'),
('Q1','2'),
('Q1','3'),
('Q1','4'), 
  ('Q1','5'), 
  ('Q1','6'), 
  ('Q1','7'), 
  ('Q1','8'), 
  ('Q1','9'), 
  ('Q1','10'), 
  ('Q1','11'), 
  ('Q1','12'), 
  ('Q1','13'),
   ('Q4','1'), 
  ('Q4','2'),
  ('Q4','3'), 
  ('Q4','4'), 
  ('Q4','5'), 
  ('Q4','6'), 
  ('Q4','7'), 
  ('Q4','8'), 
  ('Q4','9'), 
  ('Q4','10'), 
  ('Q4','11'), 
  ('Q4','12'), 
  ('Q4','13'),
  ('Q2', '1'),
  ('Q3','2');
