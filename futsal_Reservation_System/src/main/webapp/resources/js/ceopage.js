document.addEventListener("DOMContentLoaded", () => {
  const ceoname = document.querySelector("span.ceoname");
  const subtitle = document.querySelector("div.dashboard.title");

  ceoname?.addEventListener("click", () => {
    document.location.href = `${rootPath}/logout-page`;
  });

  const dashboardDetail = (e) => {
    const target = e.target;
    if (target.tagName === "SPAN") {
      const targetClassName = target.className;
      document.location.href = `${rootPath}/ceo/${targetClassName}`;
    }
  };
  subtitle?.addEventListener("click", dashboardDetail);
});
