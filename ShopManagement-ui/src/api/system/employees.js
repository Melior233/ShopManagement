import request from '@/utils/request'

// 查询商铺员工列表
export function listEmployees(query) {
  return request({
    url: '/system/employees/list',
    method: 'get',
    params: query
  })
}

// 查询商铺员工详细
export function getEmployees(id) {
  return request({
    url: '/system/employees/' + id,
    method: 'get'
  })
}

// 新增商铺员工
export function addEmployees(data) {
  return request({
    url: '/system/employees',
    method: 'post',
    data: data
  })
}

// 修改商铺员工
export function updateEmployees(data) {
  return request({
    url: '/system/employees',
    method: 'put',
    data: data
  })
}

// 删除商铺员工
export function delEmployees(id) {
  return request({
    url: '/system/employees/' + id,
    method: 'delete'
  })
}
