document.addEventListener("DOMContentLoaded", () => {
  const regBtn = document.querySelector("button.reg.button");
  const updateBtn = document.querySelector("button.update.button");
  const deleteBtn = document.querySelector("button.delete.button");

  //   regBtn?.addEventListener("click");

  //   updateBtn?.addEventListener("click");

  const deleteEventHandler = (e) => {
    const target = e.target;
    const id = target.dataset.id;
    document.location.href = `${rootPath}/delete?id=${id}`;
  };
  deleteBtn?.addEventListener("click", deleteEventHandler);
});
