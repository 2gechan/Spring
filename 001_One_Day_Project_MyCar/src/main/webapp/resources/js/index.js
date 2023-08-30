document.addEventListener("DOMContentLoaded", () => {
  const div = document.querySelector("input.div");
  const start = document.querySelector("input.start");
  const place = document.querySelector("input.place");
  const form_submit = document.querySelector("form.form-input");
  const submitBtn = document.querySelector("button");
  const list_table = document.querySelector("table.main-table");

  const inputCheck = (e) => {
    if (!div.value) {
      alert("구분은 필수 입력사항입니다.");
      div.focus();
      return false;
    }
    if (!start.value) {
      alert("시작거리는 필수 입력사항입니다.");
      start.focus();
      return false;
    }
    if (!place.value) {
      alert("장소는 필수 입력사항입니다.");
      place.focus();
      return false;
    }

    form_submit.submit();
  };

  const trClick = (e) => {
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const id = tr.dataset.id;
      document.location.href = `${rootPath}/update?id=${id}`;
    }
  };
  list_table?.addEventListener("click", trClick);

  submitBtn?.addEventListener("click", inputCheck);
});
