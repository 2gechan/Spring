document.addEventListener("DOMContentLoaded", () => {
  const trClickHandler = (e) => {
    const td = e.target;
    if (td.tagName === "TD") {
      const tr = td.closest("TR");
      const seq = tr.dataset.id;
      document.location.href = `${rootPath}board/board_detail?num=${seq}`;
    }
  };
  const board_table = document.querySelector("table.main.list");
  board_table?.addEventListener("click", trClickHandler);
});
