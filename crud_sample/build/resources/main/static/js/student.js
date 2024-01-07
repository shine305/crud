window.addEventListener('load', function () {
    const width = document.documentElement.clientWidth
    const offcanvas = document.querySelector('#offcanvasScrolling')
    offcanvas.addEventListener('hide.bs.offcanvas', event => {
        document.querySelector('.navbar-toggler[data-bs-target="#offcanvasScrolling"]').classList.add('offcanvas-hidden');
    })
    offcanvas.addEventListener('show.bs.offcanvas', event => {
        document.querySelector('#offcanvasScrolling').style.visibility = '';
        document.querySelector('.navbar-toggler[data-bs-target="#offcanvasScrolling"]').classList.remove('offcanvas-hidden');
    })
    if (width < 992) {
        document.querySelector('.navbar-toggler[data-bs-target="#offcanvasScrolling"]').click()
    }
    else {
        document.querySelector('#offcanvasScrolling').style.visibility = '';
    }
}, false);
window.addEventListener('resize', function () {
    const width = document.documentElement.clientWidth
    const toggleButton = document.querySelector('.navbar-toggler[data-bs-target="#offcanvasScrolling"]')
    if (width >= 992 && toggleButton.classList.contains('offcanvas-hidden')) {
        toggleButton.click()
    }
    else if (width < 992 && !toggleButton.classList.contains('offcanvas-hidden')){
        toggleButton.click()
    }
}, false);


