USE [master]
GO
/****** Object:  Database [qlcuahanggiaydb]    Script Date: 8/2/2023 9:43:43 PM ******/
CREATE DATABASE [qlcuahanggiaydb]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'qlcuahanggiaydb', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\qlcuahanggiaydb.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'qlcuahanggiaydb_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL16.MSSQLSERVER\MSSQL\DATA\qlcuahanggiaydb_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT, LEDGER = OFF
GO
ALTER DATABASE [qlcuahanggiaydb] SET COMPATIBILITY_LEVEL = 160
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [qlcuahanggiaydb].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [qlcuahanggiaydb] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET ARITHABORT OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [qlcuahanggiaydb] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [qlcuahanggiaydb] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET  ENABLE_BROKER 
GO
ALTER DATABASE [qlcuahanggiaydb] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [qlcuahanggiaydb] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET RECOVERY FULL 
GO
ALTER DATABASE [qlcuahanggiaydb] SET  MULTI_USER 
GO
ALTER DATABASE [qlcuahanggiaydb] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [qlcuahanggiaydb] SET DB_CHAINING OFF 
GO
ALTER DATABASE [qlcuahanggiaydb] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [qlcuahanggiaydb] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [qlcuahanggiaydb] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [qlcuahanggiaydb] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'qlcuahanggiaydb', N'ON'
GO
ALTER DATABASE [qlcuahanggiaydb] SET QUERY_STORE = ON
GO
ALTER DATABASE [qlcuahanggiaydb] SET QUERY_STORE (OPERATION_MODE = READ_WRITE, CLEANUP_POLICY = (STALE_QUERY_THRESHOLD_DAYS = 30), DATA_FLUSH_INTERVAL_SECONDS = 900, INTERVAL_LENGTH_MINUTES = 60, MAX_STORAGE_SIZE_MB = 1000, QUERY_CAPTURE_MODE = AUTO, SIZE_BASED_CLEANUP_MODE = AUTO, MAX_PLANS_PER_QUERY = 200, WAIT_STATS_CAPTURE_MODE = ON)
GO
USE [qlcuahanggiaydb]
GO
/****** Object:  User [admin]    Script Date: 8/2/2023 9:43:43 PM ******/
CREATE USER [admin] FOR LOGIN [admin] WITH DEFAULT_SCHEMA=[dbo]
GO
/****** Object:  Table [dbo].[tblchitiethd]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblchitiethd](
	[Magiay] [nvarchar](20) NOT NULL,
	[MaHD] [nvarchar](20) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[GiaBan] [money] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblchitietkm]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblchitietkm](
	[MaGiay] [nvarchar](20) NOT NULL,
	[MaKM] [nvarchar](20) NOT NULL,
	[TiLeKM] [float] NOT NULL,
 CONSTRAINT [PK_tblchitietkm] PRIMARY KEY CLUSTERED 
(
	[MaGiay] ASC,
	[MaKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblchitietpn]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblchitietpn](
	[MaGiay] [nvarchar](20) NOT NULL,
	[MaPN] [nvarchar](20) NOT NULL,
	[SoLuong] [int] NOT NULL,
	[GiaNhap] [money] NOT NULL,
 CONSTRAINT [PK_tblchitietpn] PRIMARY KEY CLUSTERED 
(
	[MaPN] ASC,
	[MaGiay] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblhoadon]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblhoadon](
	[MaHD] [nvarchar](20) NOT NULL,
	[MaNV] [nvarchar](20) NOT NULL,
	[MaKH] [nvarchar](20) NOT NULL,
	[MaKM] [nvarchar](20) NOT NULL,
	[NgayBan] [date] NOT NULL,
	[TongTien] [money] NOT NULL,
 CONSTRAINT [PK_tblhoadon] PRIMARY KEY CLUSTERED 
(
	[MaHD] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblkhachhang]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblkhachhang](
	[MaKH] [nvarchar](20) NOT NULL,
	[Ho] [nvarchar](20) NOT NULL,
	[Ten] [nvarchar](20) NOT NULL,
	[GioiTinh] [nvarchar](20) NOT NULL,
	[DiaChi] [nvarchar](40) NOT NULL,
	[Email] [nvarchar](20) NOT NULL,
	[Loai] [nvarchar](20) NOT NULL,
	[TongChiTieu] [money] NOT NULL,
 CONSTRAINT [PK__tblkhach__2725CF1E6B57EEE8] PRIMARY KEY CLUSTERED 
(
	[MaKH] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblkhuyenmai]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblkhuyenmai](
	[MaKM] [nvarchar](20) NOT NULL,
	[TenChuongTrinh] [nvarchar](40) NOT NULL,
	[LoaiChuongTrinh] [nvarchar](20) NOT NULL,
	[DieuKien] [nvarchar](20) NULL,
	[NgayBatDau] [date] NOT NULL,
	[NgayKetThuc] [date] NOT NULL,
 CONSTRAINT [PK__tblkhuye__2725CF15D271CE54] PRIMARY KEY CLUSTERED 
(
	[MaKM] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblloai]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblloai](
	[Maloai] [nvarchar](20) NOT NULL,
	[Tenloai] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Maloai] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblmausac]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblmausac](
	[Mamau] [nvarchar](20) NOT NULL,
	[Tenmau] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Mamau] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblnhacungcap]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblnhacungcap](
	[MaNCC] [nvarchar](20) NOT NULL,
	[TenNCC] [nvarchar](20) NOT NULL,
	[DiaChi] [nvarchar](40) NOT NULL,
	[Email] [nvarchar](40) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[MaNCC] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblnhanvien]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblnhanvien](
	[MaNV] [nvarchar](20) NOT NULL,
	[Ho] [nvarchar](30) NOT NULL,
	[Ten] [nvarchar](10) NOT NULL,
	[GioiTinh] [nvarchar](10) NOT NULL,
	[DiaChi] [nvarchar](50) NOT NULL,
	[DienThoai] [int] NOT NULL,
	[Email] [nvarchar](max) NOT NULL,
	[Luong] [int] NOT NULL,
	[ChucVu] [nvarchar](50) NOT NULL,
	[Anh] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK__tblnhanv__2725D70AB48B4D99] PRIMARY KEY CLUSTERED 
(
	[MaNV] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblphieunhap]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblphieunhap](
	[MaPN] [nvarchar](20) NOT NULL,
	[MaNCC] [nvarchar](20) NOT NULL,
	[MaNV] [nvarchar](20) NOT NULL,
	[NgayNhap] [date] NOT NULL,
	[TongTien] [money] NOT NULL,
 CONSTRAINT [PK__tblphieu__2725E7F0B154EF6E] PRIMARY KEY CLUSTERED 
(
	[MaPN] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblsanpham]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblsanpham](
	[Magiay] [nvarchar](20) NOT NULL,
	[Tengiay] [nvarchar](20) NOT NULL,
	[Soluong] [int] NOT NULL,
	[Gia] [money] NOT NULL,
	[Size] [int] NOT NULL,
	[Doituongsd] [nvarchar](20) NOT NULL,
	[Chatlieu] [nvarchar](20) NOT NULL,
	[Maloai] [nvarchar](20) NOT NULL,
	[Maxx] [nvarchar](20) NOT NULL,
	[Mamau] [nvarchar](20) NOT NULL,
	[Mathuonghieu] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK__tblsanph__75EBDD8BF6C09D26] PRIMARY KEY CLUSTERED 
(
	[Magiay] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbltaikhoan]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbltaikhoan](
	[tendangnhap] [nvarchar](20) NOT NULL,
	[matkhau] [nvarchar](20) NOT NULL,
	[capbac] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK__tbltaikh__CE900A1F057A7A17] PRIMARY KEY CLUSTERED 
(
	[tendangnhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblthuonghieu]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblthuonghieu](
	[Mathuonghieu] [nvarchar](20) NOT NULL,
	[Tenthuonghieu] [nvarchar](30) NOT NULL,
	[Diachi] [nvarchar](40) NOT NULL,
	[Email] [nvarchar](30) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Mathuonghieu] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tblxuatxu]    Script Date: 8/2/2023 9:43:43 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblxuatxu](
	[Maxx] [nvarchar](20) NOT NULL,
	[Tennuoc] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Maxx] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[tblchitiethd]  WITH CHECK ADD  CONSTRAINT [FKMagGiayHD] FOREIGN KEY([Magiay])
REFERENCES [dbo].[tblsanpham] ([Magiay])
GO
ALTER TABLE [dbo].[tblchitiethd] CHECK CONSTRAINT [FKMagGiayHD]
GO
ALTER TABLE [dbo].[tblchitiethd]  WITH CHECK ADD  CONSTRAINT [FKMaHD] FOREIGN KEY([MaHD])
REFERENCES [dbo].[tblhoadon] ([MaHD])
GO
ALTER TABLE [dbo].[tblchitiethd] CHECK CONSTRAINT [FKMaHD]
GO
ALTER TABLE [dbo].[tblchitietkm]  WITH CHECK ADD  CONSTRAINT [FKMaGiayKM] FOREIGN KEY([MaGiay])
REFERENCES [dbo].[tblsanpham] ([Magiay])
GO
ALTER TABLE [dbo].[tblchitietkm] CHECK CONSTRAINT [FKMaGiayKM]
GO
ALTER TABLE [dbo].[tblchitietkm]  WITH CHECK ADD  CONSTRAINT [FKMaKMCTKM] FOREIGN KEY([MaKM])
REFERENCES [dbo].[tblkhuyenmai] ([MaKM])
GO
ALTER TABLE [dbo].[tblchitietkm] CHECK CONSTRAINT [FKMaKMCTKM]
GO
ALTER TABLE [dbo].[tblchitietpn]  WITH CHECK ADD  CONSTRAINT [FKMaGiayPN] FOREIGN KEY([MaGiay])
REFERENCES [dbo].[tblsanpham] ([Magiay])
GO
ALTER TABLE [dbo].[tblchitietpn] CHECK CONSTRAINT [FKMaGiayPN]
GO
ALTER TABLE [dbo].[tblchitietpn]  WITH CHECK ADD  CONSTRAINT [FKMaPN] FOREIGN KEY([MaPN])
REFERENCES [dbo].[tblphieunhap] ([MaPN])
GO
ALTER TABLE [dbo].[tblchitietpn] CHECK CONSTRAINT [FKMaPN]
GO
ALTER TABLE [dbo].[tblhoadon]  WITH CHECK ADD  CONSTRAINT [FKMaKHHD] FOREIGN KEY([MaKH])
REFERENCES [dbo].[tblkhachhang] ([MaKH])
GO
ALTER TABLE [dbo].[tblhoadon] CHECK CONSTRAINT [FKMaKHHD]
GO
ALTER TABLE [dbo].[tblhoadon]  WITH CHECK ADD  CONSTRAINT [FKMaKMHD] FOREIGN KEY([MaKM])
REFERENCES [dbo].[tblkhuyenmai] ([MaKM])
GO
ALTER TABLE [dbo].[tblhoadon] CHECK CONSTRAINT [FKMaKMHD]
GO
ALTER TABLE [dbo].[tblhoadon]  WITH CHECK ADD  CONSTRAINT [FKMaNVHD] FOREIGN KEY([MaNV])
REFERENCES [dbo].[tblnhanvien] ([MaNV])
GO
ALTER TABLE [dbo].[tblhoadon] CHECK CONSTRAINT [FKMaNVHD]
GO
ALTER TABLE [dbo].[tblphieunhap]  WITH CHECK ADD  CONSTRAINT [FKMaNCC] FOREIGN KEY([MaNCC])
REFERENCES [dbo].[tblnhacungcap] ([MaNCC])
GO
ALTER TABLE [dbo].[tblphieunhap] CHECK CONSTRAINT [FKMaNCC]
GO
ALTER TABLE [dbo].[tblphieunhap]  WITH CHECK ADD  CONSTRAINT [FKMaNV] FOREIGN KEY([MaNV])
REFERENCES [dbo].[tblnhanvien] ([MaNV])
GO
ALTER TABLE [dbo].[tblphieunhap] CHECK CONSTRAINT [FKMaNV]
GO
ALTER TABLE [dbo].[tblsanpham]  WITH CHECK ADD  CONSTRAINT [FKMaLoai] FOREIGN KEY([Maloai])
REFERENCES [dbo].[tblloai] ([Maloai])
GO
ALTER TABLE [dbo].[tblsanpham] CHECK CONSTRAINT [FKMaLoai]
GO
ALTER TABLE [dbo].[tblsanpham]  WITH CHECK ADD  CONSTRAINT [FKMaMau] FOREIGN KEY([Mamau])
REFERENCES [dbo].[tblmausac] ([Mamau])
GO
ALTER TABLE [dbo].[tblsanpham] CHECK CONSTRAINT [FKMaMau]
GO
ALTER TABLE [dbo].[tblsanpham]  WITH CHECK ADD  CONSTRAINT [FKMaThuonghieu] FOREIGN KEY([Mathuonghieu])
REFERENCES [dbo].[tblthuonghieu] ([Mathuonghieu])
GO
ALTER TABLE [dbo].[tblsanpham] CHECK CONSTRAINT [FKMaThuonghieu]
GO
ALTER TABLE [dbo].[tblsanpham]  WITH CHECK ADD  CONSTRAINT [FKMaXuatXu] FOREIGN KEY([Maxx])
REFERENCES [dbo].[tblxuatxu] ([Maxx])
GO
ALTER TABLE [dbo].[tblsanpham] CHECK CONSTRAINT [FKMaXuatXu]
GO
ALTER TABLE [dbo].[tbltaikhoan]  WITH CHECK ADD  CONSTRAINT [FKMaNVTK] FOREIGN KEY([tendangnhap])
REFERENCES [dbo].[tblnhanvien] ([MaNV])
GO
ALTER TABLE [dbo].[tbltaikhoan] CHECK CONSTRAINT [FKMaNVTK]
GO
USE [master]
GO
ALTER DATABASE [qlcuahanggiaydb] SET  READ_WRITE 
GO
