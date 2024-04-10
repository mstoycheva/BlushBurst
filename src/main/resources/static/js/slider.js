let prev = document.querySelector(".slider-arrow-prev");
let next = document.querySelector(".slider-arrow-next");
let products = document.querySelectorAll(".catalog-item");
let products_page = Math.ceil(products.length / 3);
let l = 0;
let movePer = 10;
let maxMove = 135;

let right_mover = () => {
    l = l + movePer;
    if (products == 1) {
        l = 0;
    }
    for (const product of products) {
        if (l > maxMove) {
            l = l - movePer;
        }
        product.style.left = "-" + l + "%";
    }
};
let left_mover = () => {
    l = l - movePer;
    if (l <= 0) {
        l = 0;
    }
    for (const product of products) {
        if (products_page > 1) {
            product.style.left = "-" + l + "%";
        }
    }
};

next.onclick = () => {
    right_mover();
};
prev.onclick = () => {
    left_mover();
};
