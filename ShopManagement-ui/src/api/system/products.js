import request from '@/utils/request'

// 查询商铺商品列表
export function listProducts(query) {
  return request({
    url: '/system/products/list',
    method: 'get',
    params: query
  })
}

// 查询商铺商品详细
export function getProducts(id) {
  return request({
    url: '/system/products/' + id,
    method: 'get'
  })
}

// 新增商铺商品
export function addProducts(data) {
  return request({
    url: '/system/products',
    method: 'post',
    data: data
  })
}

// 修改商铺商品
export function updateProducts(data) {
  return request({
    url: '/system/products',
    method: 'put',
    data: data
  })
}

// 删除商铺商品
export function delProducts(id) {
  return request({
    url: '/system/products/' + id,
    method: 'delete'
  })
}
