function deleteUser(element) {
    const id= Number(element.getAttribute("name"));
    console.log("Parsed ID:", id);
    console.log('Delete user with id: ' + id);
    deleteUserHttpRequest(id).then(result => {
        console.log(result);
    });
}

async function deleteUserHttpRequest(id) {
    const response = await fetch(`/api/v1/users/${id}`, {
        method: "DELETE",
    });
    return response.status; // returns only the status
}

function deleteProduct(element) {
    const id= Number(element.getAttribute("data-product-id"));
    console.log("Parsed ID:", id);
    console.log('Delete user with id: ' + id);
    deleteProductHttpRequest(id).then(result => {
        console.log(result);
    });
}

async function deleteProductHttpRequest(id) {
    const response = await fetch(`/api/v1/products/${id}`, {
        method: "DELETE",
    });
    return response.status; // returns only the status
}

function deleteCompany(element) {
    const id= Number(element.getAttribute("name"));
    console.log("Parsed ID:", id);
    console.log('Delete company with id: ' + id);
    deleteCompanyHttpRequest(id).then(result => {
        console.log(result);
    });
}

async function deleteCompanyHttpRequest(id) {
    const response = await fetch(`/api/v1/companies/${id}`, {
        method: "DELETE",
    });
    return response.status; // returns only the status
}

function deleteIngredient(element) {
    const id= Number(element.getAttribute("name"));
    console.log("Parsed ID:", id);
    console.log('Delete company with id: ' + id);
    deleteIngredientHttpRequest(id).then(result => {
        console.log(result);
    });
}

async function deleteIngredientHttpRequest(id) {
    const response = await fetch(`/api/v1/ingredients/${id}`, {
        method: "DELETE",
    });
    return response.status; // returns only the status
}
//document.addEventListener('DOMContentLoaded', async () => {
//    const searchForm = document.getElementById('search-form');
//    const searchBox = document.getElementById('search-box');
//    const productSlider = document.getElementsByClassName('section-hero');
//    if (!searchForm || !searchBox || !productSlider) {
//        console.error('One or more required elements not found.');
//        return;
//    }
//    searchForm.addEventListener('submit', async (e) => {
//        e.preventDefault();
//        const searchQuery = searchBox.value.trim();
//        if (!searchQuery) {
//            return;
//        }
//        productSlider.innerHTML = 'Loading...';
//        try {
//            const response = await fetch(`http://localhost:8080/allproducts`);
//
//            if (!response.ok) {
//                throw new Error(`Failed to fetch products. Status: ${response.status} ${response.statusText}`);
//            }
//            const products = await response.json();
//            console.log('Fetched products:', products);
//            const filteredProducts = products.filter(product =>
//                product.name.toLowerCase().includes(searchQuery.toLowerCase()) ||
//                product.description.toLowerCase().includes(searchQuery.toLowerCase()) ||
//                product.price.toLowerCase().includes(searchQuery.toLowerCase())
//            );
//            displayProducts(filteredProducts);
//        } catch (error) {
//            console.error('Error fetching products:', error);
//            productSlider.innerHTML = 'Error fetching products.';
//        }
//    });
//});
//
//function displayProducts(products) {
//    const productSlider = document.getElementsByClassName('catalog')[0]; // Assuming there's only one element with class 'catalog'
//    if (!productSlider) {
//        console.error('Product slider element not found.');
//        return;
//    }
//
//    if (products.length === 0) {
//        productSlider.innerHTML = 'No products found.';
//        return;
//    }
//
//    // Clear previous content
//    productSlider.innerHTML = '';
//
//    // Create and append product elements
//    products.forEach(product => {
//        const catalogItem = document.createElement('li');
//        catalogItem.classList.add('catalog-item');
//        catalogItem.innerHTML = `
//            <div class="item-attributes">
//                <h4 class="item-title">${product.name}</h4>
//                <div class="item-details">
//                    <p class="item-short-descr">${product.description}</p>
//                    <span class="item-price">${product.price}</span>
//                </div>
//                <div class="item-actions">
//                    <a class="item-action action-view" href="/product-details/${product.id}">ВИЖТЕ ПОВЕЧЕ</a>
//                </div>
//
//            </div>
//        `;
//        productSlider.appendChild(catalogItem);
//    });
//
//    initializeSlider(".slider-arrow-prev", ".slider-arrow-next", ".catalog-item");
//}
//
//
//function initializeSlider(prevSelector, nextSelector, productsSelector) {
//    let prev = document.querySelector(prevSelector);
//    let next = document.querySelector(nextSelector);
//    let products = document.querySelectorAll(productsSelector);
//    let products_page = Math.ceil(products.length / 3);
//    let l = 0;
//    let movePer = 10;
//    let maxMove = 135;
//
//    let right_mover = () => {
//        l = l + movePer;
//        if (products == 1) {
//            l = 0;
//        }
//        for (const product of products) {
//            if (l > maxMove) {
//                l = l - movePer;
//            }
//            product.style.left = "-" + l + "%";
//        }
//    };
//
//    let left_mover = () => {
//        l = l - movePer;
//        if (l <= 0) {
//            l = 0;
//        }
//        for (const product of products) {
//            if (products_page > 1) {
//                product.style.left = "-" + l + "%";
//            }
//        }
//    };
//
//    next.onclick = () => {
//        right_mover();
//    };
//
//    prev.onclick = () => {
//        left_mover();
//    };
//}

