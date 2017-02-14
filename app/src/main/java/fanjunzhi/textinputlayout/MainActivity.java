package fanjunzhi.textinputlayout;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.tv_setting)
    TextView tvSetting;

    @BindView(R.id.bt_login_ok)
    Button btnLogin;

//    @BindView(R.id.tl_login_account)
//    android.support.design.widget.TextInputLayout tlLoginAccount;

    @BindView(R.id.tl_login_password)
    android.support.design.widget.TextInputLayout tlLoginPassword;

    @BindView(R.id.et_login_email)
    EditText userEmail;

    @BindView(R.id.et_login_password)
    EditText password;

    @BindView(R.id.rl_setting)
    RelativeLayout systemSetting;

    private Boolean isShowUserError = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    /**
     * 按钮点击事件
     * @param view
     */
    @OnClick({R.id.bt_login_ok, R.id.rl_setting})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login_ok:
                login();
                break;
        }
    }

    /**
     * 登录点击事件
     */
    public void login() {
        if (isShowUserError) {
            userEmail.setFocusable(true);
            userEmail.requestFocus();
            userEmail.setError("我是账号错误");
            password.setError(null);
        } else {
            password.setFocusable(true);
            password.requestFocus();
            password.setError("我是密码错误");
            userEmail.setError(null);
        }

        isShowUserError = !isShowUserError;
    }
}
