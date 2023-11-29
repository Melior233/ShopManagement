import request from '@/utils/request'

// 查询商铺员工考勤记录列表
export function listAttendance(query) {
  return request({
    url: '/system/attendance/list',
    method: 'get',
    params: query
  })
}

// 查询商铺员工考勤记录详细
export function getAttendance(id) {
  return request({
    url: '/system/attendance/' + id,
    method: 'get'
  })
}

// 新增商铺员工考勤记录
export function addAttendance(data) {
  return request({
    url: '/system/attendance',
    method: 'post',
    data: data
  })
}

// 修改商铺员工考勤记录
export function updateAttendance(data) {
  return request({
    url: '/system/attendance',
    method: 'put',
    data: data
  })
}

// 删除商铺员工考勤记录
export function delAttendance(id) {
  return request({
    url: '/system/attendance/' + id,
    method: 'delete'
  })
}
