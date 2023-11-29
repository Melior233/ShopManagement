import request from '@/utils/request'

// 查询商铺仓库列表
export function listWarehouses(query) {
  return request({
    url: '/system/warehouses/list',
    method: 'get',
    params: query
  })
}

// 查询商铺仓库详细
export function getWarehouses(id) {
  return request({
    url: '/system/warehouses/' + id,
    method: 'get'
  })
}

// 新增商铺仓库
export function addWarehouses(data) {
  return request({
    url: '/system/warehouses',
    method: 'post',
    data: data
  })
}

// 修改商铺仓库
export function updateWarehouses(data) {
  return request({
    url: '/system/warehouses',
    method: 'put',
    data: data
  })
}

// 删除商铺仓库
export function delWarehouses(id) {
  return request({
    url: '/system/warehouses/' + id,
    method: 'delete'
  })
}
