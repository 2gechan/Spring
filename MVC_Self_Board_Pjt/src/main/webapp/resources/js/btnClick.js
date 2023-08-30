document.addEventListener("DOMContentLoaded", () => {
  const wirte_btn = document.querySelector("span.write_btn");
  wirte_btn?.addEventListener("click", () => {
    document.location.href = `${rootPath}board/board_write`;
  });

  const best_btn = document.querySelector("span.best_btn");
  best_btn?.addEventListener("click", () => {
    document.location.href = `${rootPath}board/best`;
  });

  const boardhome_btn = document.querySelector("button.boardhome_btn");
  boardhome_btn?.addEventListener("click", () => {
    document.location.href = `${rootPath}board/`;
  });

  const update_btn = document.querySelector("button.update_btn");
  update_btn?.addEventListener("click", () => {
    const id = update_btn.dataset.update;

    document.location.href = `${rootPath}board/board_update?num=${id}`;
  });

  const update_form = document.querySelector("form.main.update");
  const update_submit = document.querySelector("button.go_update_btn");
  const update_seq = document.querySelector("form.main.update");

  update_submit?.addEventListener("click", () => {
    const seq = update_seq.dataset.update;
    update_form.submit();
  });
});
