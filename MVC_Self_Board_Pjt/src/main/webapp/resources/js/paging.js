document.addEventListener("DOMContentLoaded", () => {
  const bPage = document.querySelector("li.bPage");
  const nPage = document.querySelector("li.nPage");

  bPage?.addEventListener("click", () => {
    const beforePage = bPage.dataset.id;
    console.log(beforePage);
    const intPage = parseInt(beforePage) - 1;
    console.log(intPage);

    document.location.href = `${rootPath}board?page=${intPage}`;
  });

  nPage?.addEventListener("click", () => {
    const nextPage = nPage.dataset.id;
    console.log(nextPage);
    const intPage = parseInt(nextPage) + 1;
    console.log(intPage);

    document.location.href = `${rootPath}board?page=${intPage}`;
  });
});
