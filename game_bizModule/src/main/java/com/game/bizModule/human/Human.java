package com.game.bizModule.human;

import com.game.bizModule.human.bizServ.HumanNaming;
import com.game.bizModule.human.entity.HumanEntity;
import com.game.gameServer.framework.Player;
import com.game.part.GameError;
import com.game.part.util.Assert;
import com.game.part.util.NullUtil;

import java.lang.ref.WeakReference;
import java.text.MessageFormat;

/**
 * 角色,
 * <font color="#990000">注意: 角色自己就是自己的财务</font>
 * 
 * @author hjj2017
 * @since 2015/7/11
 *
 */
public final class Human extends AbstractHumanBelonging<HumanEntity> {
	/** 服务器名称 */
	public String _serverName = null;
	/** 角色名称 */
	public String _humanName = null;
	/** 角色等级 */
	public int _humanLevel = 1;
	/** 金币 */
	public int _gold = 0;

	/** 玩家引用 */
	private WeakReference<Player> _pRef = null;

	/**
	 * 类默认构造器
	 *
	 * @param UId
	 *
	 */
	private Human(long UId) {
		super(UId);
	}

	/**
	 * 获取角色全名
	 *
	 * @return
	 *
	 */
	public String getFullName() {
		return HumanNaming.OBJ.getFullName(this._serverName, this._humanName);
	}

	/**
	 * 获取玩家对象
	 *
	 * @return
	 *
	 */
	public Player getPlayer() {
		if (this._pRef == null) {
			return null;
		} else {
			return this._pRef.get();
		}
	}

	/**
	 * 抱住玩家的大腿!
	 *
	 * @param p
	 *
	 */
	public void bindPlayer(Player p) {
		if (p == null) {
			// 如果参数对象为空,
			// 则直接退出!
			return;
		}

		if (this._pRef != null &&
			this._pRef.get() != null) {
			// 如果已经绑定过玩家,
			// 则直接抛出异常!
			throw new GameError(MessageFormat.format(
				"不能重复绑定玩家, 角色 = {0}, 绑定到玩家 = {1}",
				String.valueOf(this._humanUId),
				p._platformUIdStr
			));
		}

		// 设置玩家引用
		this._pRef = new WeakReference<>(p);
	}

	/**
	 * 从玩家对象获取角色
	 *
	 * @param p
	 * @return
	 *
	 */
	public static Human getHumanByPlayer(Player p) {
		if (p == null) {
			return null;
		} else {
			return p.getPropVal(Human.class);
		}
	}

	/**
	 * @see Player#getPropValOrCreate(Class)
	 */
	public<T> T getPropValOrCreate(Class<T> byClazz) {
		if (this.getPlayer() != null) {
			return this.getPlayer().getPropValOrCreate(byClazz);
		} else {
			return null;
		}
	}

	/**
	 * @see Player#getPropVal(Class)
	 */
	public<T> T getPropVal(Class<T> byClazz) {
		if (this.getPlayer() != null) {
			return this.getPlayer().getPropVal(byClazz);
		} else {
			return null;
		}
	}

	/**
	 * 创建角色实体
	 *
	 * @return
	 *
	 */
	@Override
	public HumanEntity toEntity() {
		// 创建角色实体
		HumanEntity he = new HumanEntity();
		// 设置实体属性
		he._humanUId = this._humanUId;
		he._platformUIdStr = this.getPlayer()._platformUIdStr;
		he._fullName = this.getFullName();
		he._serverName = this._serverName;
		he._humanName = this._humanName;

		return he;
	}

	/**
	 * 从角色实体中加载数据
	 *
	 * @param entity
	 *
	 */
	public void fromEntity(HumanEntity entity) {
		if (entity == null) {
			// 如果参数对象为空,
			// 则直接退出!
			return;
		}

		this._serverName = entity._serverName;
		this._humanName = entity._humanName;
		this._humanLevel = NullUtil.optVal(entity._humanLevel, this._humanLevel);
		this._gold = NullUtil.optVal(entity._gold, this._gold);
	}

	/**
	 * 创建角色
	 *
	 * @param entity
	 * @return
	 *
	 */
	public static Human create(HumanEntity entity) {
		// 断言参数不为空
		Assert.notNull(entity);
		// 创建角色并加载数据
		Human h = new Human(entity._humanUId);
		h.fromEntity(entity);

		return h;
	}
}
