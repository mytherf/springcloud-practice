-- ----------------------------
-- Table structure for user_info
-- ----------------------------
IF EXISTS (SELECT * FROM sys.all_objects WHERE object_id = OBJECT_ID(N'[dbo].[user_info]') AND type IN ('U'))
	DROP TABLE [dbo].[user_info]
GO

CREATE TABLE [dbo].[user_info] (
  [id] int  IDENTITY(1,1) NOT NULL,
  [username] varchar(255) COLLATE Chinese_PRC_CI_AS  NOT NULL,
  [password] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [usertype] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [enabled] int  NULL,
  [realname] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [qq] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [email] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [tel] varchar(255) COLLATE Chinese_PRC_CI_AS  NULL,
  [create_time] datetime  NULL
)
GO

ALTER TABLE [dbo].[user_info] SET (LOCK_ESCALATION = TABLE)
GO


-- ----------------------------
-- Primary Key structure for table user_info
-- ----------------------------
ALTER TABLE [dbo].[user_info] ADD CONSTRAINT [PK__user_inf__3213E83FD42899CA] PRIMARY KEY CLUSTERED ([id])
WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)  
ON [PRIMARY]
GO

