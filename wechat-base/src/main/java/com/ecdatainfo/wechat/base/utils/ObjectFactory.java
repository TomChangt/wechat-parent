package com.ecdatainfo.wechat.base.utils;

public abstract class ObjectFactory<S,T> {

	public void before(S source, T target) {

    }

	public abstract T newInstance();

	public void after(S source, T target) {

	}
}