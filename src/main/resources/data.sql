-- ============================================================
-- Seed data cho bài test N+1 / Batch fetch (Patient - Checkup)
-- File này chạy MỖI LẦN app khởi động (sau khi Hibernate tạo bảng)
-- nên có DELETE đầu file để không bị nhân đôi data khi restart
-- ============================================================

DELETE FROM checkups;
DELETE FROM patients;

INSERT INTO patients (id, full_name, citizen_id, created_at) VALUES
(1,  'Nguyễn Văn An',      '012345678901', '2026-01-05 08:30:00'),
(2,  'Trần Thị Bình',      '012345678902', '2026-01-12 09:15:00'),
(3,  'Lê Minh Cường',      '012345678903', '2026-02-01 10:00:00'),
(4,  'Phạm Thu Hà',        '012345678904', '2026-02-10 14:20:00'),
(5,  'Hoàng Văn Dũng',     '012345678905', '2026-02-18 11:45:00'),
(6,  'Ngô Thị Én',         '012345678906', '2026-03-02 08:00:00'),
(7,  'Đặng Văn Phong',     '012345678907', '2026-03-15 15:30:00'),
(8,  'Bùi Minh Gia',       '012345678908', '2026-03-22 13:10:00'),
(9,  'Vũ Thị Hồng',        '012345678909', '2026-04-01 09:50:00'),
(10, 'Đỗ Văn Khánh',       '012345678910', '2026-04-09 16:00:00'),
(11, 'Nguyễn Thị Linh',    '012345678911', '2026-04-20 10:30:00'),
(12, 'Trần Văn Minh',      '012345678912', '2026-05-03 08:45:00'),
(13, 'Lê Thu Nga',         '012345678913', '2026-05-11 14:00:00'),
(14, 'Phạm Văn Oanh',      '012345678914', '2026-05-25 11:20:00'),
(15, 'Hoàng Thị Pơ',       '012345678915', '2026-06-02 09:00:00');

INSERT INTO checkups (id, diagnosis, patient_id) VALUES
-- Bệnh nhân 1 (3 lần khám)
(1,  'Cảm cúm thông thường',        1),
(2,  'Viêm họng cấp',               1),
(3,  'Khám sức khỏe định kỳ',       1),
-- Bệnh nhân 2 (2 lần)
(4,  'Đau dạ dày',                  2),
(5,  'Viêm loét tá tràng',          2),
-- Bệnh nhân 3 (3 lần)
(6,  'Tăng huyết áp',               3),
(7,  'Theo dõi huyết áp tại nhà',  3),
(8,  'Đái tháo đường type 2',       3),
-- Bệnh nhân 4 (2 lần)
(9,  'Dị ứng thực phẩm',            4),
(10, 'Viêm da tiếp xúc',            4),
-- Bệnh nhân 5 (3 lần)
(11, 'Đau lưng cơ học',             5),
(12, 'Trượt đĩa đệm đốt sống thắt lưng', 5),
(13, 'Vật lý trị liệu',             5),
-- Bệnh nhân 6 (2 lần)
(14, 'Viêm xoang',                  6),
(15, 'Ngứa mắt allergic',           6),
-- Bệnh nhân 7 (2 lần)
(16, 'Gãy xương cánh tay',          7),
(17, 'Tháo bột và kiểm tra',        7),
-- Bệnh nhân 8 (3 lần)
(18, 'Sốt xuất huyết',              8),
(19, 'Theo dõi tiểu cầu',           8),
(20, 'Khám hậu phục',               8),
-- Bệnh nhân 9 (2 lần)
(21, 'Thiếu máu',                   9),
(22, 'Bổ sung sắt và folate',        9),
-- Bệnh nhân 10 (3 lần)
(23, 'Viêm phổi',                   10),
(24, 'Chụp X-quang ngực',           10),
(25, 'Tái khám phổi',               10),
-- Bệnh nhân 11 (2 lần)
(26, 'Mất ngủ',                     11),
(27, 'Tư vấn giấc ngủ',             11),
-- Bệnh nhân 12 (3 lần)
(28, 'Viêm ruột thừa',              12),
(29, 'Phẫu thuật ruột thừa',        12),
(30, 'Khám sau phẫu thuật',         12),
-- Bệnh nhân 13 (2 lần)
(31, 'Cận thị',                     13),
(32, 'Đo mắt và lắp kính',          13),
-- Bệnh nhân 14 (2 lần)
(33, 'Viêm tai giữa',               14),
(34, 'Nhỏ tai và tái khám',         14),
-- Bệnh nhân 15 (1 lần)
(35, 'Khám tổng quát',              15);
