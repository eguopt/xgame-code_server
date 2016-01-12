﻿using System;

using Xgame.GameClient.Global;
using Xgame.GameClient.Kernel.Msg;
using Xgame.GamePart.Msg.Type;

namespace Xgame.GameClient.Human.Msg
{
    /// <summary>
    /// 进入角色
    /// </summary>
    public partial class CGEnterHuman : BaseCGMsg
    {
        /** 角色 UId */
        public MsgLong _humanUId;
        /** 角色 UId 字符串 */
        public MsgStr _humanUIdStr;

        // @Override
        public override short MsgSerialUId
        {
            get
            {
                return AllMsgSerialUId.CG_ENTER_HUMAN;
            }
        }
    }
}
