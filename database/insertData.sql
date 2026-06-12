USE MeoMeoTea;
GO

INSERT INTO NhanVien VALUES
('NV01', N'Nguyễn Văn An', '0912345678', N'Thu ngân', 7000000),
('NV02', N'Nguyễn Tiến Đạt', '0912345679', N'Thu ngân', 7000000),
('NV03', N'Phạm Ngọc Huế', '0912345670', N'Thu ngân', 7000000),
('NV04', N'Trần Thị Bình', '0923456789', N'Pha chế', 8000000),
('NV05', N'Lê Văn Cường', '0934567890', N'Phục vụ', 6000000);

INSERT INTO TaiKhoan VALUES
('admin', 'admin123', N'QuanLy', NULL),
('nv01', '123456', N'NhanVien', 'NV01'),
('nv02', '123456', N'NhanVien', 'NV02'),
('nv03', '123456', N'NhanVien', 'NV03');

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

INSERT INTO KhachHang VALUES
('KH01', N'Nguyễn Văn Nam', '0912345678', N'Hà Nội'),
('KH02', N'Trần Thị Lan', '0923456789', N'Hải Phòng'),
('KH03', N'Lê Minh Tuấn', '0934567890', N'Nam Định'),
('KH04', N'Phạm Thị Hương', '0945678901', N'Thái Bình'),
('KH05', N'Hoàng Quốc Bảo', '0956789012', N'Hưng Yên');

INSERT INTO HoaDon VALUES
('HD01', '2026-06-01 09:15:00', 95000, 'NV01'),
('HD02', '2026-06-02 10:20:00', 70000, 'NV02'),
('HD03', '2026-06-03 11:30:00', 85000, 'NV03'),
('HD04', '2026-06-04 14:00:00', 125000, 'NV01'),
('HD05', '2026-06-05 15:10:00', 99000, 'NV02'),
('HD06', '2026-06-06 16:20:00', 88000, 'NV03'),
('HD07', '2026-06-07 09:45:00', 105000, 'NV01'),
('HD08', '2026-06-08 13:15:00', 93000, 'NV02'),
('HD09', '2026-06-09 17:40:00', 120000, 'NV03'),
('HD10', '2026-06-10 19:00:00', 124000, 'NV01');

INSERT INTO ChiTietHoaDon VALUES
('HD01','SP01',N'Trà sữa truyền thống',1,25000,25000),
('HD01','SP02',N'Trà đào cam sả',1,30000,30000),
('HD01','SP05',N'Trà sữa matcha',1,40000,40000),

('HD02','SP01',N'Trà sữa truyền thống',1,25000,25000),
('HD02','SP03',N'Hồng trà sữa',1,35000,35000),
('HD02','SP06',N'Trà chanh',1,10000,10000),

('HD03','SP02',N'Trà đào cam sả',1,30000,30000),
('HD03','SP04',N'Trà xoài',1,32000,32000),
('HD03','SP06',N'Trà chanh',1,23000,23000),

('HD04','SP05',N'Trà sữa matcha',1,40000,40000),
('HD04','SP03',N'Hồng trà sữa',1,35000,35000),
('HD04','SP08',N'Trà dâu',1,33000,33000),
('HD04','SP06',N'Trà chanh',1,17000,17000),

('HD05','SP04',N'Trà xoài',1,32000,32000),
('HD05','SP07',N'Trà vải',1,28000,28000),
('HD05','SP01',N'Trà sữa truyền thống',1,25000,25000),
('HD05','SP06',N'Trà chanh',1,14000,14000),

('HD06','SP03',N'Hồng trà sữa',1,35000,35000),
('HD06','SP04',N'Trà xoài',1,32000,32000),
('HD06','SP06',N'Trà chanh',1,21000,21000),

('HD07','SP01',N'Trà sữa truyền thống',1,25000,25000),
('HD07','SP02',N'Trà đào cam sả',1,30000,30000),
('HD07','SP05',N'Trà sữa matcha',1,40000,40000),
('HD07','SP06',N'Trà chanh',1,10000,10000),

('HD08','SP04',N'Trà xoài',1,32000,32000),
('HD08','SP03',N'Hồng trà sữa',1,35000,35000),
('HD08','SP06',N'Trà chanh',1,26000,26000),

('HD09','SP05',N'Trà sữa matcha',1,40000,40000),
('HD09','SP09',N'Trà sữa khoai môn',1,38000,38000),
('HD09','SP08',N'Trà dâu',1,33000,33000),
('HD09','SP06',N'Trà chanh',1,9000,9000),

('HD10','SP10',N'Trà sữa socola',1,42000,42000),
('HD10','SP09',N'Trà sữa khoai môn',1,38000,38000),
('HD10','SP08',N'Trà dâu',1,33000,33000),
('HD10','SP06',N'Trà chanh',1,11000,11000);

