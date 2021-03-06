USE [master]
GO
/****** Object:  Database [电影院]    Script Date: 2018/1/5 9:21:24 ******/
CREATE DATABASE [电影院]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'test', FILENAME = N'D:\sql\MSSQL14.SQLEXPRESS03\MSSQL\DATA\test.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'test_log', FILENAME = N'D:\sql\MSSQL14.SQLEXPRESS03\MSSQL\DATA\test_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [电影院] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [电影院].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [电影院] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [电影院] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [电影院] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [电影院] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [电影院] SET ARITHABORT OFF 
GO
ALTER DATABASE [电影院] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [电影院] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [电影院] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [电影院] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [电影院] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [电影院] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [电影院] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [电影院] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [电影院] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [电影院] SET  DISABLE_BROKER 
GO
ALTER DATABASE [电影院] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [电影院] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [电影院] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [电影院] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [电影院] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [电影院] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [电影院] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [电影院] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [电影院] SET  MULTI_USER 
GO
ALTER DATABASE [电影院] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [电影院] SET DB_CHAINING OFF 
GO
ALTER DATABASE [电影院] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [电影院] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [电影院] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [电影院] SET QUERY_STORE = OFF
GO
USE [电影院]
GO
ALTER DATABASE SCOPED CONFIGURATION SET IDENTITY_CACHE = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION SET LEGACY_CARDINALITY_ESTIMATION = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET LEGACY_CARDINALITY_ESTIMATION = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET MAXDOP = 0;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET MAXDOP = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET PARAMETER_SNIFFING = ON;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET PARAMETER_SNIFFING = PRIMARY;
GO
ALTER DATABASE SCOPED CONFIGURATION SET QUERY_OPTIMIZER_HOTFIXES = OFF;
GO
ALTER DATABASE SCOPED CONFIGURATION FOR SECONDARY SET QUERY_OPTIMIZER_HOTFIXES = PRIMARY;
GO
USE [电影院]
GO
/****** Object:  Table [dbo].[排片类型]    Script Date: 2018/1/5 9:21:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[排片类型](
	[排片id] [int] NOT NULL,
	[价格] [smallint] NOT NULL,
	[剩余票数] [smallint] NOT NULL,
 CONSTRAINT [PK_排片类型] PRIMARY KEY CLUSTERED 
(
	[排片id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[订单]    Script Date: 2018/1/5 9:21:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[订单](
	[订单id] [int] IDENTITY(1,1) NOT NULL,
	[购买时间] [datetime] NOT NULL,
	[排片id] [int] NOT NULL,
	[用户id] [int] NOT NULL,
	[座位号] [tinyint] NOT NULL,
	[实付金额] [tinyint] NULL,
 CONSTRAINT [PK_订单] PRIMARY KEY CLUSTERED 
(
	[订单id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[排片]    Script Date: 2018/1/5 9:21:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[排片](
	[排片id] [int] NOT NULL,
	[电影名] [nchar](10) NOT NULL,
	[放映厅id] [int] NOT NULL,
	[场次] [datetime] NOT NULL,
 CONSTRAINT [PK_排片] PRIMARY KEY CLUSTERED 
(
	[排片id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[查看订单]    Script Date: 2018/1/5 9:21:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[查看订单]
AS
SELECT   dbo.订单.订单id, dbo.订单.用户id, dbo.排片.电影名, dbo.排片.放映厅id, dbo.排片.场次, dbo.订单.购买时间, 
                dbo.订单.实付金额
FROM      dbo.订单 LEFT OUTER JOIN
                dbo.排片 ON dbo.订单.排片id = dbo.排片.排片id LEFT OUTER JOIN
                dbo.排片类型 ON dbo.排片.排片id = dbo.排片类型.排片id
GO
/****** Object:  Table [dbo].[电影]    Script Date: 2018/1/5 9:21:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[电影](
	[电影名] [nchar](10) NOT NULL,
	[导演] [nchar](10) NOT NULL,
	[主演] [nchar](10) NOT NULL,
	[上映日期] [date] NOT NULL,
	[影片时长] [nchar](10) NOT NULL,
	[简介] [nchar](100) NOT NULL,
 CONSTRAINT [PK_电影] PRIMARY KEY CLUSTERED 
(
	[电影名] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[放映厅]    Script Date: 2018/1/5 9:21:24 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[放映厅](
	[放映厅id] [tinyint] IDENTITY(1,1) NOT NULL,
	[座位数] [nchar](10) NULL,
	[规格] [tinyint] NULL,
 CONSTRAINT [PK_放映厅] PRIMARY KEY CLUSTERED 
(
	[放映厅id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[用户]    Script Date: 2018/1/5 9:21:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[用户](
	[用户id] [int] NOT NULL,
	[姓名] [nchar](8) NOT NULL,
	[密码] [nchar](15) NOT NULL,
	[性别] [nchar](4) NOT NULL,
	[类型] [int] NOT NULL,
 CONSTRAINT [PK_用户] PRIMARY KEY CLUSTERED 
(
	[用户id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[电影] ([电影名], [导演], [主演], [上映日期], [影片时长], [简介]) VALUES (N'1         ', N'1         ', N'1         ', CAST(N'2018-01-04' AS Date), N'123       ', N'123                                                                                                 ')
INSERT [dbo].[电影] ([电影名], [导演], [主演], [上映日期], [影片时长], [简介]) VALUES (N'芳华        ', N'冯小刚       ', N'黄轩        ', CAST(N'2017-12-15' AS Date), N'136       ', N'在充满理想和激情的军队文工团，一群正值芳华的青春少年，经历着成长中的爱情萌发与充斥变数的人生命运。乐于助人、                                              ')
INSERT [dbo].[电影] ([电影名], [导演], [主演], [上映日期], [影片时长], [简介]) VALUES (N'破局        ', N'连奕琦       ', N'刘涛        ', CAST(N'2017-08-17' AS Date), N'112       ', N'该片改编自韩国电影《走到尽头》，讲述刑警高见翔在参加母亲葬礼的路上意外撞死了一名通缉犯，他手忙脚乱“毁尸灭迹”，驾车逃逸被警方盯上，后被告知是一个阴谋深陷迷局的故事                  ')
INSERT [dbo].[电影] ([电影名], [导演], [主演], [上映日期], [影片时长], [简介]) VALUES (N'悟空传       ', N'郭子健       ', N'彭于晏       ', CAST(N'2017-07-13' AS Date), N'123       ', N'该片改编自今何在同名小说《悟空传》，讲述了五百年前，未成为齐天大圣的孙悟空，不服天命，向天地诸神发起抗争的故事                                             ')
INSERT [dbo].[电影] ([电影名], [导演], [主演], [上映日期], [影片时长], [简介]) VALUES (N'心理罪之城市之光  ', N'徐纪周       ', N'邓超        ', CAST(N'2017-12-22' AS Date), N'124       ', N'该片改编自雷米系列犯罪小说《心理罪》最后一部《城市之光》，讲述了神探方木抓捕高智商变态杀人犯的故事。                                                  ')
SET IDENTITY_INSERT [dbo].[订单] ON 

INSERT [dbo].[订单] ([订单id], [购买时间], [排片id], [用户id], [座位号], [实付金额]) VALUES (8, CAST(N'2017-12-27T14:20:00.000' AS DateTime), 1, 0, 45, 30)
INSERT [dbo].[订单] ([订单id], [购买时间], [排片id], [用户id], [座位号], [实付金额]) VALUES (9, CAST(N'2017-12-27T14:20:00.000' AS DateTime), 1, 0, 18, 30)
INSERT [dbo].[订单] ([订单id], [购买时间], [排片id], [用户id], [座位号], [实付金额]) VALUES (10, CAST(N'2017-12-27T14:20:00.000' AS DateTime), 1, 1, 57, 30)
SET IDENTITY_INSERT [dbo].[订单] OFF
SET IDENTITY_INSERT [dbo].[放映厅] ON 

INSERT [dbo].[放映厅] ([放映厅id], [座位数], [规格]) VALUES (1, N'50        ', 8)
INSERT [dbo].[放映厅] ([放映厅id], [座位数], [规格]) VALUES (2, N'30        ', 5)
INSERT [dbo].[放映厅] ([放映厅id], [座位数], [规格]) VALUES (3, N'40        ', 8)
SET IDENTITY_INSERT [dbo].[放映厅] OFF
INSERT [dbo].[排片] ([排片id], [电影名], [放映厅id], [场次]) VALUES (1, N'芳华        ', 1, CAST(N'2017-12-27T14:20:00.000' AS DateTime))
INSERT [dbo].[排片] ([排片id], [电影名], [放映厅id], [场次]) VALUES (2, N'芳华        ', 1, CAST(N'2017-12-27T16:20:00.000' AS DateTime))
INSERT [dbo].[排片] ([排片id], [电影名], [放映厅id], [场次]) VALUES (3, N'心理罪之城市之   ', 2, CAST(N'2017-12-27T14:20:00.000' AS DateTime))
INSERT [dbo].[排片] ([排片id], [电影名], [放映厅id], [场次]) VALUES (6, N'悟空传       ', 2, CAST(N'2017-12-28T08:00:00.000' AS DateTime))
INSERT [dbo].[排片] ([排片id], [电影名], [放映厅id], [场次]) VALUES (7, N'破局        ', 3, CAST(N'2017-12-28T08:00:00.000' AS DateTime))
INSERT [dbo].[排片] ([排片id], [电影名], [放映厅id], [场次]) VALUES (8, N'破局        ', 1, CAST(N'2017-12-27T14:20:00.000' AS DateTime))
INSERT [dbo].[排片] ([排片id], [电影名], [放映厅id], [场次]) VALUES (10, N'芳华        ', 2, CAST(N'2017-12-19T00:00:00.000' AS DateTime))
INSERT [dbo].[排片] ([排片id], [电影名], [放映厅id], [场次]) VALUES (11, N'1         ', 3, CAST(N'2018-01-04T00:00:00.000' AS DateTime))
INSERT [dbo].[排片类型] ([排片id], [价格], [剩余票数]) VALUES (1, 30, 53)
INSERT [dbo].[排片类型] ([排片id], [价格], [剩余票数]) VALUES (2, 50, 50)
INSERT [dbo].[排片类型] ([排片id], [价格], [剩余票数]) VALUES (8, 5, 50)
INSERT [dbo].[排片类型] ([排片id], [价格], [剩余票数]) VALUES (10, 25, 30)
INSERT [dbo].[排片类型] ([排片id], [价格], [剩余票数]) VALUES (11, 52, 40)
INSERT [dbo].[用户] ([用户id], [姓名], [密码], [性别], [类型]) VALUES (0, N'lv      ', N'1              ', N'男   ', 0)
INSERT [dbo].[用户] ([用户id], [姓名], [密码], [性别], [类型]) VALUES (1, N'li      ', N'1              ', N'女   ', 1)
INSERT [dbo].[用户] ([用户id], [姓名], [密码], [性别], [类型]) VALUES (2, N'wang    ', N'1              ', N'男   ', 1)
INSERT [dbo].[用户] ([用户id], [姓名], [密码], [性别], [类型]) VALUES (3, N'王       ', N'1              ', N'男   ', 0)
INSERT [dbo].[用户] ([用户id], [姓名], [密码], [性别], [类型]) VALUES (6, N'吕       ', N'1              ', N'男   ', 1)
ALTER TABLE [dbo].[订单]  WITH CHECK ADD  CONSTRAINT [FK_订单_用户] FOREIGN KEY([用户id])
REFERENCES [dbo].[用户] ([用户id])
GO
ALTER TABLE [dbo].[订单] CHECK CONSTRAINT [FK_订单_用户]
GO
ALTER TABLE [dbo].[排片类型]  WITH CHECK ADD  CONSTRAINT [FK_排片类型_排片] FOREIGN KEY([排片id])
REFERENCES [dbo].[排片] ([排片id])
GO
ALTER TABLE [dbo].[排片类型] CHECK CONSTRAINT [FK_排片类型_排片]
GO
/****** Object:  StoredProcedure [dbo].[取消订单]    Script Date: 2018/1/5 9:21:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[取消订单](@1 int,@2 int)
AS
 delete from 订单 where 订单id =@1
 update 排片类型
 set 剩余票数=剩余票数+1
 where 排片id=@2
GO
/****** Object:  StoredProcedure [dbo].[剩余票数]    Script Date: 2018/1/5 9:21:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[剩余票数] 
@放映厅id int,@剩余票数 int OUTPUT
AS
SELECT @剩余票数=座位数
from 放映厅
where 放映厅id=@放映厅id
GO
/****** Object:  StoredProcedure [dbo].[实付金额]    Script Date: 2018/1/5 9:21:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE procedure [dbo].[实付金额] 
@排片id int,@用户id int,@价格 int OUTPUT
AS
SELECT @价格=0.8*价格
from 用户,排片类型
where 用户id=@用户id and 类型=1and 排片id=@排片id
SELECT @价格=价格
from 用户,排片类型
where 用户id=@用户id and 类型!=2and 排片id=@排片id
GO
/****** Object:  StoredProcedure [dbo].[添加订单]    Script Date: 2018/1/5 9:21:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[添加订单](@1 datetime,@2 int,@3 int,@4 int)
AS
  declare @5 int
  exec 实付金额 @2,@3,@价格=@5 output
  insert into 订单(购买时间,排片id,用户id,座位号,实付金额)
  values (@1,@2,@3,@4,@5)
    update 排片类型
  set 剩余票数=剩余票数-1
  where 排片id=@2
GO
/****** Object:  StoredProcedure [dbo].[添加排片]    Script Date: 2018/1/5 9:21:25 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[添加排片](@1 int,@2 nchar(10),@3 int,@4 datetime,@5 int)
AS
  insert into 排片(排片id,电影名,放映厅id,场次)
  values (@1,@2,@3,@4)
  declare @6 int
  exec 剩余票数 @3,@剩余票数=@6 output
  insert into 排片类型(排片id,价格,剩余票数)
  values (@1,@5,@6)

GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[31] 4[37] 2[16] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "订单"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 146
               Right = 180
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "排片"
            Begin Extent = 
               Top = 6
               Left = 218
               Bottom = 146
               Right = 360
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "排片类型"
            Begin Extent = 
               Top = 6
               Left = 398
               Bottom = 127
               Right = 540
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 2985
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'查看订单'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'查看订单'
GO
USE [master]
GO
ALTER DATABASE [电影院] SET  READ_WRITE 
GO
