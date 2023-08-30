document.addEventListener("DOMContentLoaded", () => {
  const updateBtn = document.querySelector("button.updateBtn");
  const updateForm = document.querySelector("form.update-form");
  const deleteBtn = document.querySelector("button.deleteBtn");
  const seq = document.querySelector("input.seq");

  updateBtn?.addEventListener("click", () => {
    updateForm.submit();
  });

  deleteBtn?.addEventListener("click", () => {
    const id = seq.value;
    location.href = `delete?id=${id}`;
  });
});
