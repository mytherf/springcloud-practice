-- ----------------------------
-- Table structure for user_reg_stat
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[user_reg_stat]') AND type IN ('U'))
	DROP TABLE [dbo].[user_reg_stat]
GO

CREATE TABLE [dbo].[user_reg_stat] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [reg_date] date  NOT NULL,
  [reg_type] int  NULL,
  [reg_area] varchar(255) COLLATE Chinese_PRC_90_CI_AS  NULL,
  [reg_num] int DEFAULT ((0)) NOT NULL,
  [create_time] datetime  NOT NULL
)
GO

ALTER TABLE [dbo].[user_reg_stat] SET (LOCK_ESCALATION = TABLE)
GO

EXEC sp_addextendedproperty
'MS_Description', N'注册日期',
'SCHEMA', N'dbo',
'TABLE', N'user_reg_stat',
'COLUMN', N'reg_date'
GO

EXEC sp_addextendedproperty
'MS_Description', N'注册类型',
'SCHEMA', N'dbo',
'TABLE', N'user_reg_stat',
'COLUMN', N'reg_type'
GO

EXEC sp_addextendedproperty
'MS_Description', N'注册地区',
'SCHEMA', N'dbo',
'TABLE', N'user_reg_stat',
'COLUMN', N'reg_area'
GO

EXEC sp_addextendedproperty
'MS_Description', N'注册数量',
'SCHEMA', N'dbo',
'TABLE', N'user_reg_stat',
'COLUMN', N'reg_num'
GO

EXEC sp_addextendedproperty
'MS_Description', N'创建时间',
'SCHEMA', N'dbo',
'TABLE', N'user_reg_stat',
'COLUMN', N'create_time'
GO


-- ----------------------------
-- Primary Key structure for table user_reg_stat
-- ----------------------------
ALTER TABLE [dbo].[user_reg_stat] ADD CONSTRAINT [PK__user_reg__3213E83F93212725] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

