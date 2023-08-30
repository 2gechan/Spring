document.addEventListener("DOMContentLoaded", () => {
  const navClickHandler = (e) => {
    const target = e.target;

    if (target.tagName === "LI") {
      const targetClassName = target.className;
      let URL = `${rootPath}` + targetClassName;
      const USER_URL = "join mypage login logout";

      if (targetClassName === "home") {
        URL = `${rootPath}`;
      } else if (targetClassName === "admin") {
        URL = `${rootPath}admin`;
      } else if (USER_URL.includes(targetClassName)) {
        URL = `${rootPath}user/` + targetClassName;
      } else if (targetClassName === "boardhome") {
        URL = `${rootPath}board/`;
      }
      document.location.href = URL;
    }
  };

  const menu = document.querySelector("nav.main");
  menu.addEventListener("click", navClickHandler);
});
