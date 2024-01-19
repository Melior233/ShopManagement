import request from '@/utils/request'

// 查询仓库信息列表
export function listWarehouse(query) {
  return request({
    url: '/biz/warehouse/list',
    method: 'get',
    params: query
  })
}

// 查询仓库信息详细
export function getWarehouse(warehouseId) {
  return request({
    url: '/biz/warehouse/' + warehouseId,
    method: 'get'
  })
}

// 新增仓库信息
export function addWarehouse(data) {
  return request({
    url: '/biz/warehouse',
    method: 'post',
    data: data
  })
}

// 修改仓库信息
export function updateWarehouse(data) {
  return request({
    url: '/biz/warehouse',
    method: 'put',
    data: data
  })
}

// 删除仓库信息
export function delWarehouse(warehouseId) {
  return request({
    url: '/biz/warehouse/' + warehouseId,
    method: 'delete'
  })
}
