package com.example.demo.domain;

import java.util.Collection;
import java.util.Date;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor // フィールドなしのコンストラクタを自動で作成
@AllArgsConstructor // 全てのフィールドを引数に持つコンストラクタを自動で作成する
@Builder // Builderクラスを自動で作成する
public class AppUserDetails implements UserDetails {
	
	@NotEmpty(message = "入力エラーです")
	@Min(value = 1)
	private String user_id; 
	private String password;
	private Date passUpdateDate; //パスワード更新日
	private int loginMissTimes; //ログイン失敗回数
	private boolean unlock; //ロック状態フラグ
	private boolean enabled; // 有効・無効フラグ
	private Date userDueDate; // ユーザー有効期限
	// 権限のコレクション
	private Collection<? extends GrantedAuthority> authority;
	private String tenantId; //テナントID
	private String appUserName; // ユーザー名
	private String mailAddress; //メアド
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO 自動生成されたメソッド・スタブ
		return authority;
	}

	@Override
	public String getPassword() {
		// TODO 自動生成されたメソッド・スタブ
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO 自動生成されたメソッド・スタブ
		return this.user_id;
	}

	/*
	 * アカウントの有効期限チェック
	 * true:有効  false:無効
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		if(this.userDueDate.after(new Date())) {
			return true;
		}else {
			return false;
		}
		
	}

	/*
	 * アカウントのロックチェック
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	// パスワードの有効期限
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO 自動生成されたメソッド・スタブ
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO 自動生成されたメソッド・スタブ
		return this.enabled;
	}

	

}
