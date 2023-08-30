document.addEventListener("DOMContentLoaded", () => {
  const myFunction = () => {
    const joinBtn = document.querySelector("button.join");
    const joinForm = document.querySelector("form.main.join");

    const id = document.querySelector("#u_id");
    const pwd1 = document.querySelector("#u_pwd1");
    const pwd2 = document.querySelector("#u_pwd2");
    const name = document.querySelector("#u_name");
    const tel = document.querySelector("#u_tel");
    const addr = document.querySelector("#u_addr");

    const error_boxs = document.querySelectorAll("div.error");
    const error_id = document.querySelector("div.error.id");
    const error_pwd1 = document.querySelector("div.error.pwd1");
    const error_pwd2 = document.querySelector("div.error.pwd2");
    const error_name = document.querySelector("div.error.name");
    const error_tel = document.querySelector("div.error.tel");
    const error_addr = document.querySelector("div.error.addr");

    const error_clear = () => {
      for (let e of error_boxs) {
        e.classList.remove("on");
      }
    };

    id?.select();

    const form_check = () => {
      if (!id.value) {
        error_clear();
        id.focus();
        error_id.classList.add("on");
        error_id.innerHTML = "ID란을 입력하세요";
        return false;
      }
      if (!pwd1.value) {
        error_clear();
        pwd1.focus();
        error_pwd1.classList.add("on");
        error_pwd1.innerHTML = "패스워드란을 입력하세요";

        return false;
      }
      if (!pwd2.value) {
        error_clear();
        pwd2.focus();
        error_pwd2.classList.add("on");
        error_pwd2.innerHTML = "패스워드 확인란을 입력하세요";
        return false;
      }

      if (pwd1.value !== pwd2.value) {
        error_clear();
        pwd1.focus();
        error_pwd1.classList.add("on");
        error_pwd2.classList.add("on");
        error_pwd1.innerHTML = "패스워드가 일치하지 않습니다.";
        error_pwd2.innerHTML = "패스워드가 일치하지 않습니다.";
      }

      if (!name.value) {
        error_clear();
        name.focus();
        error_name.classList.add("on");
        error_name.innerHTML = "이름을 입력하세요";
        return false;
      }
      if (!tel.value) {
        error_clear();
        tel.focus();
        error_tel.classList.add("on");
        error_tel.innerHTML = "전화번호를 입력하세요";
        return false;
      }
      if (!addr.value) {
        error_clear();
        addr.focus();
        error_addr.classList.add("on");
        error_addr.innerHTML = "주소를 입력하세요";
        return false;
      }
      joinForm.submit();
    };
    joinBtn?.addEventListener("click", form_check);
  };
});

// window.addEventListener("DOMContentLoaded", myFunction);
