package com.example.demo.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LogAspect {
	
	/**
	 * サービスの実行前にログ出力する
	 * 対象：『MaterialsService』をクラス名に含んでる
	 */
	@Before("execution(* *..*.*MaterialsService.*(..))")
	public void startLog(JoinPoint jp) {
		log.info("メソッド開始:" + jp.getSignature());
	}
	
	/**
	 * サービスの実行後にログ出力する
	 * 対象：『MaterialsService』をクラス名に含んでる
	 */
	@After("execution(* *..*.*MaterialsService.*(..))")
	public void endLog(JoinPoint jp) {
		log.info("メソッド終了:" + jp.getSignature());
	}
	
	@Around("@within(org.springframework.stereotype.Controller)")
	public Object startLog(ProceedingJoinPoint jp) throws Throwable{
		
		//開始ログの出力
		log.info("メソッド開始：" + jp.getSignature());
		
		try {
			//メソッドの実行
			Object result = jp.proceed();
			
			//終了ログの出力
			log.info("メソッドの終了:" + jp.getSignature());
			
			//実行結果を呼び出し元に変換
			return result;
		}catch (Exception e) {
			
			//エラーログ出力
			log.error("メソッド異常終了:" + jp.getSignature());
			
			//エラーログ出力
			throw e;
		}
		
		
	}
	

}
