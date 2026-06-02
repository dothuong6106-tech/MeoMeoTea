USE MeoMeoTea;
GO

INSERT INTO TaiKhoan VALUES
('admin','123456','QuanLy'),
('nv01','123456','NhanVien');

INSERT INTO SanPham VALUES
('SP01', N'Trà sữa truyền thống', 25000, 100),
('SP02', N'Trà đào cam sả', 30000, 80),
('SP03', N'Hồng trà sữa', 35000, 60),
('SP04', N'Trà xoài', 32000, 70),
('SP05', N'Trà sữa matcha', 40000, 50),
('SP06', N'Trà chanh', 20000, 120),
('SP07', N'Trà vải', 28000, 90),
('SP08', N'Trà dâu', 33000, 75),
('SP09', N'Trà sữa khoai môn', 38000, 40),
('SP10', N'Trà sữa socola', 42000, 35);

INSERT INTO NhanVien VALUES
('NV01', N'Nguyễn Văn An', '0901234567', N'Thu ngân', 7000000),
('NV02', N'Trần Thị Bình', '0902345678', N'Pha chế', 7500000),
('NV03', N'Lê Văn Cường', '0903456789', N'Phục vụ', 6500000);

INSERT INTO KhachHang VALUES
('KH01', N'Nguyễn Văn Nam', '0912345678', N'Hà Nội'),
('KH02', N'Trần Thị Lan', '0923456789', N'Hải Phòng'),
('KH03', N'Lê Minh Tuấn', '0934567890', N'Nam Định'),
('KH04', N'Phạm Thị Hương', '0945678901', N'Thái Bình'),
('KH05', N'Hoàng Quốc Bảo', '0956789012', N'Hưng Yên');

INSERT INTO HoaDon VALUES
('HD01', '2026-06-01 08:30:00', 80000, 'KH01', 'NV01'),
('HD02', '2026-06-01 09:15:00', 95000, 'KH02', 'NV02'),
('HD03', '2026-06-01 10:00:00', 65000, 'KH03', 'NV01'),
('HD04', '2026-06-01 11:20:00', 120000, 'KH04', 'NV03'),
('HD05', '2026-06-01 14:45:00', 105000, 'KH05', 'NV02');

INSERT INTO ChiTietHoaDon VALUES
('HD01', 'SP01', N'Trà sữa truyền thống', 2, 25000, 50000),
('HD01', 'SP02', N'Trà đào cam sả', 1, 30000, 30000);

INSERT INTO ChiTietHoaDon VALUES
('HD02', 'SP03', N'Hồng trà sữa', 1, 35000, 35000),
('HD02', 'SP05', N'Trà sữa matcha', 1, 40000, 40000),
('HD02', 'SP06', N'Trà chanh', 1, 20000, 20000);

INSERT INTO ChiTietHoaDon VALUES
('HD03', 'SP04', N'Trà xoài', 1, 32000, 32000),
('HD03', 'SP06', N'Trà chanh', 1, 20000, 20000);

INSERT INTO ChiTietHoaDon VALUES
('HD04', 'SP05', N'Trà sữa matcha', 2, 40000, 80000),
('HD04', 'SP08', N'Trà dâu', 1, 33000, 33000);

INSERT INTO ChiTietHoaDon VALUES
('HD05', 'SP09', N'Trà sữa khoai môn', 1, 38000, 38000),
('HD05', 'SP10', N'Trà sữa socola', 1, 42000, 42000),
('HD05', 'SP06', N'Trà chanh', 1, 20000, 20000);

INSERT INTO HoaDon VALUES
('HD06', '2026-06-05 09:00:00', 73000, 'KH01', 'NV01'),
('HD07', '2026-06-08 14:20:00', 68000, 'KH03', 'NV02'),
('HD08', '2026-06-12 16:10:00', 115000, 'KH02', 'NV03'),
('HD09', '2026-06-18 10:45:00', 78000, 'KH05', 'NV01'),
('HD10', '2026-06-25 19:30:00', 125000, 'KH04', 'NV02');

INSERT INTO ChiTietHoaDon VALUES
('HD06', 'SP02', N'Trà đào cam sả', 1, 30000, 30000),
('HD06', 'SP08', N'Trà dâu', 1, 33000, 33000),
('HD06', 'SP06', N'Trà chanh', 1, 10000, 10000);

INSERT INTO ChiTietHoaDon VALUES
('HD07', 'SP01', N'Trà sữa truyền thống', 1, 25000, 25000),
('HD07', 'SP07', N'Trà vải', 1, 28000, 28000),
('HD07', 'SP06', N'Trà chanh', 1, 15000, 15000);

INSERT INTO ChiTietHoaDon VALUES
('HD08', 'SP05', N'Trà sữa matcha', 2, 40000, 80000),
('HD08', 'SP04', N'Trà xoài', 1, 35000, 35000);

INSERT INTO ChiTietHoaDon VALUES
('HD09', 'SP03', N'Hồng trà sữa', 1, 35000, 35000),
('HD09', 'SP02', N'Trà đào cam sả', 1, 30000, 30000),
('HD09', 'SP06', N'Trà chanh', 1, 13000, 13000);

INSERT INTO ChiTietHoaDon VALUES
('HD10', 'SP10', N'Trà sữa socola', 2, 42000, 84000),
('HD10', 'SP08', N'Trà dâu', 1, 33000, 33000),
('HD10', 'SP06', N'Trà chanh', 1, 8000, 8000);